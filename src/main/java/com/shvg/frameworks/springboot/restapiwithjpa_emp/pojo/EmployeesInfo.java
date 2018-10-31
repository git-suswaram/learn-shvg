package com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo;

import java.util.List;

public class EmployeesInfo{
	private List<EmployeeInfo> employeeInfo;

	public void setEmployeeInfo(List<EmployeeInfo> employeeInfo){
		this.employeeInfo = employeeInfo;
	}

	public List<EmployeeInfo> getEmployeeInfo(){
		return employeeInfo;
	}

	@Override
 	public String toString(){
		return 
			"EmployeesInfo{" + 
			"employeeInfo = '" + employeeInfo + '\'' + 
			"}";
		}
}