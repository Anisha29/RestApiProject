package MyRest.apis;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.preemptive;

import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.AuthenticationScheme;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;

public class TestCases extends BaseClass {

	@BeforeClass
	public static void Setup() {

		RestAssured.baseURI = "https://predix-appd-service-broker.run.aws-usw02-dev.ice.predix.io";
		AuthenticationScheme authenticationScheme = preemptive().basic("predix_appd", "predixPass2012");
		RestAssured.authentication = authenticationScheme;
		RestAssured.useRelaxedHTTPSValidation();

	}

	@Test
	@Ignore
	public void validatePlans() {
		ExtractableResponse<Response> response = given().contentType("application/json").when().get("/catalog").then()
				.contentType(ContentType.JSON).extract();
		List<JSONObject> ids = response.path("plans.id");
		Assert.assertEquals(3, ids.size());
		System.out.println(ids);

		List<String> planstoVerify = Arrays.asList("poc", "predix-test", "predix-prod");
		Assert.assertTrue(planstoVerify.equals(ids));

	}

	@Test
	public void createService() {
		JSONObject createServiceObj = createServiceObj("app1", Plan.TEST);

		
		given().contentType("application/json").body(createServiceObj.toString()).
		when().put("/service_instances/101").
		then().statusCode(200);
	}

	@Test	
	public void createDupService() {
		JSONObject createServiceObj = createServiceObj("app1", Plan.TEST);

		given().contentType("application/json").body(createServiceObj.toString()).
		when().put("/service_instances/101").
		then().statusCode(409);
	}
	
	@Test
	public void createDeletService() {
		given().contentType("application/json").
		when().delete("/service_instances/101").
		then().statusCode(200);
		}
}

