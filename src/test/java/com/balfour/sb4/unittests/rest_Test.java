package com.balfour.sb4.unittests;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

public class rest_Test {

	@Test
	public void stringTest001() {
		String id = "fakeass";
		String key = "users";
		int val = 1;
		String expected = "{\"users\": []}";
		// int expected = 200;

		// ValidatableResponse var = given().header("x-Auth-Token",
		// "ADMIN").and()
		// .contentType(ContentType.JSON)
		// .get("http://10.90.31.54:8000/users?email=" + id).then()
		// .body(key, hasSize(lessThan(val)));

		Response response = given().header("x-Auth-Token", "ADMIN").and()
				.contentType(ContentType.JSON).expect().statusCode(200)
				.get("http://10.90.31.54:8000/users?email=" + id);

		String responseBody = response.getBody().asString().trim();
		System.out.print(responseBody);

		if (expected.equals(responseBody)) {
			System.out.println("you win");
			System.out.print(expected);
		} else {
			System.err.println("you lose");
			System.out.print(expected);
		}

		// int responseBody = response.getStatusCode();
		// System.out.print(responseBody);

		// if (expected == responseBody) {
		// System.out.println("you win");
		// System.out.print(expected);
		// } else {
		// System.err.println("you lose");
		// System.out.print(expected);
		// }

	}
}
