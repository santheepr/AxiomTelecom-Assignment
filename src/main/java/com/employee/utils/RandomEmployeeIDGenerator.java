package com.employee.utils;

import java.io.IOException;
import java.util.Random;

public class RandomEmployeeIDGenerator {
	
	// Select a random row from the test data sheet
	public static int selectRandomEmployeeID() throws IOException {
		Random random = new Random();
		int randomEmployeeID = random.nextInt(XLUtils.getEmployeeCount());
		return randomEmployeeID;
	}
}
