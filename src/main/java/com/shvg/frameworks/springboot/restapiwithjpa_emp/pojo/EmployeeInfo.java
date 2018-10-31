package com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo;

public class EmployeeInfo {
	private Employee employee;

	public void setEmployee(Employee employee){
		this.employee = employee;
	}

	public Employee getEmployee(){
		return employee;
	}

	@Override
 	public String toString(){
		return 
			"EmployeeInfo{" +
			"employee = '" + employee + '\'' + 
			"}";
		}
}
