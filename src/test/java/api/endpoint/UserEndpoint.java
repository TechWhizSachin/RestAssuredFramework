package api.endpoint;
import static io.restassured.RestAssured.given;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndpoint {

	public static Response tests(User payload) {
		
		Response res=given()
			.contentType(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_URL);
		
		return res;
	}
	
public static Response tests1(String username) {
		
		Response res1=given()
			.pathParam("username", username)
		.when()
			.get(Routes.get_URL);
		return res1;
	}

public static Response tests2(User payload,String username) {
	
	Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
		.body(payload)
	.when()
		.put(Routes.put_URL);
	return res;
}

public static Response tests3(String username) {
	
	Response res=given()
		.pathParam("username", username)
	.when()
		.delete(Routes.delete_URL);
	return res;
}

}
