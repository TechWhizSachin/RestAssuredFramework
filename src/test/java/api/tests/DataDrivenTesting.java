package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.UserEndpoint;
import api.payloads.User;
import api.utilities.DataProvider1;
import io.restassured.response.Response;

public class DataDrivenTesting {
	
	
	@Test(priority=1,dataProvider="allData", dataProviderClass=DataProvider1.class)
	public void testProvider(String UserID,String UserName,String FirstName,String LastName,String Email,String	Password,String	Phone) {
		int j=0;
		int i=j+1;
		System.out.println("post request"+ i);
		User u=new User();
		u.setId(Integer.parseInt(UserID));
		u.setUsername(UserName);
		u.setFirstName(FirstName);
		u.setLastName(LastName);
		u.setEmail(Email);
		u.setPassword(Password);
		u.setPhone(Phone);
		
		Response response=UserEndpoint.tests(u);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=2, dataProvider="userNames",dataProviderClass=DataProvider1.class)
	public void delete(String usernames) {
		int j=0;
		int i=j+1;
		System.out.println("Delete request"+i++);
		User u=new User();
		Response res=UserEndpoint.tests3(usernames);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
