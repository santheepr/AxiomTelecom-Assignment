package com.employees.pojo.employeelistapi;

import java.util.List;

public class EmployeeList {

	private String status;
	private List<AllData> data;
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<AllData> getData() {
		return data;
	}

	public void setData(List<AllData> data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
