package com.employee.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.employee.utils.ExtractURL;
import com.employees.pojo.employeelistapi.EmployeeList;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Scenario1_GetAllEmployeesTest extends TestBase {
	private Response response;
	private RequestSpecification requestspec;
	private EmployeeList employeeList;

	public static Logger log = Logger.getLogger(Scenario1_GetAllEmployeesTest.class.getName());

	@Test
	public void getAllEmployeesRequest() {
		log.info("*****************Start Test******************");
		
		//Start extent report
		test = extent.createTest("getAllEmployeesRequest");
		
		// Extract the Base URI from the request URL in Config file
		RestAssured.baseURI = ExtractURL.getEmployeeListURI();
		requestspec = RestAssured.given();
		response = requestspec.request(Method.GET, ExtractURL.getEmployeeListResourcePath());

		// Verify that request body is not null
		String responsebody = response.getBody().asString();
		Assert.assertTrue(responsebody != null);
		log.info("Response is not null");

		// Verify that status response code 200 is received
		int statuscode = response.getStatusCode();
		log.info("Status code is " + statuscode);
		Assert.assertEquals(statuscode, 200);

		// Verify that success message is received
		employeeList = response.getBody().as(EmployeeList.class);
		log.info("Success message received : " + employeeList.getMessage());
		Assert.assertEquals(employeeList.getMessage(), "Successfully! All records has been fetched.");

		// Verify that profile_image is blank for all employees
		for(int i=0; i < employeeList.getData().size(); i++) {
		String profileImage=employeeList.getData().get(1).getProfile_image();
		Assert.assertEquals(profileImage, "");
		}
		log.info("Profile_image is blank for all employees");
		
		log.info("*****************End Test******************");
	}
}