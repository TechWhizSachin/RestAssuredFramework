package api.endpoint;
/*
Swagger URI --> https://petstore.swagger.io
Create user(Post): https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/{username} 
Update user (Put): https://petstore.swagger.io/v2/user/{username}
Delete user (Delete): https://petstore.swagger.io/v2/user/{username}
*/
public class Routes {
public static String base_URL="https://petstore.swagger.io/v2";

//User model url's
public static String post_URL=base_URL+"/user";
public static String get_URL=base_URL+"/user/{username}";
public static String put_URL=base_URL+"/user/{username}";
public static String delete_URL=base_URL+"/user/{username}";

}
