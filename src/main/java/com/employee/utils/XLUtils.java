package com.employee.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	private static String xlfile = "src\\main\\resources\\TestData.xlsx";
	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;

	//Select the EmployeeID from test data sheet
	public int getEmployeeID(int rownum, int cellnum) throws IOException {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		row = sheet.getRow(RandomEmployeeIDGenerator.selectRandomEmployeeID());
		cell = row.getCell(0);
		int celldata = (int) cell.getNumericCellValue();
		workbook.close();
		fis.close();
		return celldata;
	}

	// Returns the total number of rows from the testdata sheet
	public static int getEmployeeCount() throws IOException {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		int totalRows = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return totalRows;
	}
}