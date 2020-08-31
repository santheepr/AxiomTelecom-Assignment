package com.employee.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.employee.pojo.singleemployeeapi.Employee;
import com.employee.utils.ExtractURL;
import com.employee.utils.RandomEmployeeIDGenerator;
import com.employee.utils.XLUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Scenario2_GetSingleEmployeeTest extends TestBase {
	private static Response response;
	private RequestSpecification requestspec;
	private Employee employee;
	
	public static Logger log = Logger.getLogger(Scenario2_GetSingleEmployeeTest.class.getName());

	@Test
	public void getOneEmployeeRequest() {
		log.info("*****************Start Test******************");

		// Start extent report
		test = extent.createTest("getOneEmployeeRequest");

		// Extract the Base URI from the request URL in Config file
		RestAssured.baseURI = ExtractURL.getSingleEmployeeURI();
		requestspec = RestAssured.given();

		/* RandomGenerator.selectRandomEmployeeID() selects a random employee from the list in the testdata sheet*/
		/* "ExtractURL.getResourcePath2()" selects the resource name from the Config file and appends it with Employee ID to generate the request URL */
		try {
			response = requestspec.request(Method.GET, ExtractURL.getSingleEmployeeResourcePath() + RandomEmployeeIDGenerator.selectRandomEmployeeID());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Verify that request body is not null
		String responsebody = response.getBody().asString();
		log.info("Response body is not null");
		Assert.assertTrue(responsebody != null);

		// Verify that status response code 200 is received
		int statuscode = response.getStatusCode();
		log.info("Status code is " + statuscode);
		Assert.assertEquals(statuscode, 200);

		// Verify that success message is received
		String successmessage = response.jsonPath().get("message").toString();
		log.info("Success message received :" + successmessage);
		Assert.assertEquals(successmessage, "Successfully! Record has been fetched.");

		// Verify the response body pattern against the pojo classes
		employee = response.getBody().as(Employee.class);
		
		//Print the response body
		log.info(response.getBody().asString());
			
		log.info("*****************End Test******************");
	}
}