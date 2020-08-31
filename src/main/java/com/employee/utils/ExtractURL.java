package com.employee.utils;

public class ExtractURL {

	//Utilities to extract BaseURI and Resource path from the config file
	public static String getEmployeeListURI() {
		return Config.getEmployeeListURL().split("api/")[0];
	}

	public static String getEmployeeListResourcePath() {
		return Config.getEmployeeListURL().split("com/")[1];
	}
	
	public static String getSingleEmployeeURI() {
		return Config.getSingleEmployeeURL().split("api/")[0];
	}

	public static String getSingleEmployeeResourcePath() {
		return Config.getSingleEmployeeURL().split("com/")[1];
	}
}