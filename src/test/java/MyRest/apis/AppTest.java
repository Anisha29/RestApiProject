package MyRest.apis;

import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.TestContext;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.AuthenticationScheme;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.response.ValidatableResponse;


public class AppTest

{

	private String myjsonString;
/*
	@Test
	public void TC1() {
		
		 int respCode = given().contentType("application/json").when().get("http://localhost:8080/message?name=test&age=10")
		.then().extract().statusCode();
		 assertEquals(200,respCode);
	}

	@Test
	public void TC2() {
		
		 int respCode = given().contentType("application/json").when().get("http://localhost:8080/message")
		.then().extract().statusCode();
		 assertEquals(400,respCode);
	}

	@Test
	public void TC3() {
		
		 int respCode = given().contentType("application/json").when().get("http://localhost:8080/message?name=anisha")
		.then().extract().statusCode();
		 assertEquals(400,respCode);
	}
	
	@Test
	public void TC4() {
		
		String name = given().contentType("application/json").when().get("http://localhost:8080/message?name=anisha&age=10")
		.then().extract().body().jsonPath().get("content");
		System.out.println(name);
		
		String statusLIne = given().contentType("application/json").when().get("http://localhost:8080/message?name=anisha&age=10")
				.then().extract().response().getStatusLine();
		System.out.println(statusLIne);

		 assertEquals("HTTP/1.1 200 ",statusLIne);
	}
	
	@Test
	public void TC5() {
		
		 int respCode = given().contentType("application/json").when().get("http://localhost:8080/status")
		.then().extract().statusCode();
		 assertEquals(200,respCode);
}
	
	
	@Test
	public void TC6() {
		
		 String respCode = given().contentType("text/plain").when().get("http://localhost:8080/status")
		.then().extract().contentType();
		 assertEquals("text/plain;charset=UTF-8",respCode);
	}
	
	@Test
	public void TC9(){
		String resp = given().contentType("application/json").when().get("/generateNumber").then().extract().contentType();
		System.out.println(resp);
		assertEquals("application/json;charset=UTF-8",resp);//body type is null in this
		
		
      // given().contentType("application/json").when().get("/generateNumber").then().statusCode(200);

	}
	
	@Test
	public void TC10(){
		
		JSONObject myObj = new JSONObject();
		
		myObj.put("id", 700);
		myObj.put("password", "abcfg");
		given().contentType("application/json").body(myjsonString).when().post("/createUser").then().extract().statusCode();
		String response = given().contentType("application/json").body(myjsonString).when().post("/createUser").then().extract().asString();
		assertEquals(myjsonString,response);
	}
	
	/*@Test
	
	public void TC7(){
		
		JSONObject myObj = new JSONObject();
		
		myObj.put("id",500);
		myObj.put("content","abcd");
		
		String myjsonString = new String("{\"id\":30,\"content\":\"abcd\"}");
		
		given().contentType("application/json").body(myjsonString).when().post("/message").then().statusCode(200);
		String response = given().contentType("application/json").body(myjsonString).when().post("/message").then().extract().asString();
		
		assertEquals(myjsonString,response);
		
	}*/
	
	@Test
	@Ignore
	public void TC8() {
		
		  given().contentType("application/json").when().get("http://localhost:8080/advice")
		.then().extract().statusCode();
	
	}
	
	

	
	
}