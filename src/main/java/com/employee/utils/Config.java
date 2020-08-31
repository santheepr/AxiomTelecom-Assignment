package com.employee.utils;

import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

public class Config {

	private static Properties properties;
	private static final String configPath = "src\\main\\resources\\config.properties";

	public static void initConfigRead() throws Exception {
		properties = new Properties();
		Reader fileReader = new FileReader(configPath);
		properties.load(fileReader);
	}

	public static String getEmployeeListURL() {
		return properties.get("employee_listapi").toString();
	}
	
	public static String getSingleEmployeeURL() {
		return properties.get("single_employeeapi").toString();
	}
}