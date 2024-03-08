package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UserEndpoint;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTest {
	Faker f=new Faker();
	User u=new User();
	User u1=new User();
	String username="master.class";
	
	String username1=f.name().username();
	public Logger logger;
	@BeforeClass
	public void setupData() {
		
		u.setId(f.idNumber().hashCode());
		u.setUsername(f.name().username());
		u.setFirstName(f.name().firstName());
		u.setLastName(f.name().lastName());
		u.setEmail(f.internet().emailAddress());
		u.setPassword(f.internet().password());
		u.setPhone(f.phoneNumber().cellPhone());
	
		logger=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void test1() {
		logger.info("-----Creating user-----");
		
		Response response=UserEndpoint.tests(u);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=2)
	public void test2() {
		logger.info("-----getting user-----");
		
		Response response=UserEndpoint.tests1(u.getUsername());
		System.out.println(u.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=3)
	public void putiing() {
		logger.info("-----updating user-----");
		
		u1.setFirstName(f.name().firstName());
		u1.setLastName(f.name().lastName());
		u1.setEmail(f.internet().emailAddress());
		
		Response response=UserEndpoint.tests2(this.u1,this.u.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		Response response1=UserEndpoint.tests1(u.getUsername());
		System.out.println(u.getUsername());
		response1.then().log().all();
	}
	@Test(priority=4)
	public void deleting() {
		logger.info("-----deleting user-----");
		
		Response response=UserEndpoint.tests3(this.u.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		
	}
	
}
