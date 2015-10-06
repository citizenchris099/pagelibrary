package com.balfour.publishing.qa.pages.sb4;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

/**
 * special utility class whose method are used to generate random string. x *
 * 
 * @author cmanning
 * 
 */
public class RestUtil {

	/**
	 * used to interrogate enfold json responses
	 * 
	 * @param url
	 *            : url of enfold instance
	 * @param val1
	 *            : uuid or string to search for
	 * @param key
	 *            : that you're interested in getting back
	 * @param val2
	 *            : expected value
	 */
	public void enfoldCheck(String url, String val1, String key, String val2) {

		given().header("x-Auth-Token", "ADMIN").and()
				.contentType(ContentType.JSON).get(url + val1).then()
				.body(key, equalTo(val2));

	}

	/**
	 * used to interrogate enfold json responses returns the json as string i
	 * specifically use this to seach for users
	 * 
	 * @param url
	 *            : url of enfold instance
	 * @param id
	 *            : uuid or string to search for
	 * @return : json as string
	 */
	public String enfoldCheckString(String url, String id) {

		Response response = given().header("x-Auth-Token", "ADMIN").and()
				.contentType(ContentType.JSON).expect().statusCode(200)
				.get(url + id);

		String responseBody = response.getBody().asString().trim();

		return responseBody;

	}

	/**
	 * used to interrogate enfold responses codes
	 * 
	 * @param url
	 *            : of enfold instance and resource
	 * @param id
	 *            : uuid or string to search for
	 * 
	 * @return : responce code
	 */
	public int enfoldCheckCode(String url, String id) {

		Response response = given().header("x-Auth-Token", "ADMIN").and()
				.contentType(ContentType.JSON).expect().statusCode(404)
				.get(url + id);

		int code = response.getStatusCode();

		return code;
	}

	public String guerrillamail() {
		Response response = given().contentType(ContentType.JSON).expect()
				.statusCode(200).get("https://api.guerrillamail.com/ajax.php?f=get_email_address");
		String code = response.path("email_addr");
//		return code+"@guerrillamailblock.com";
		return code;
	}

}
