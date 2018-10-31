package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

public class DepartmentDetails{
	private String departmentID;
	private String departmentName;
	private String totalEmployeeCount;

	public void setTotalEmployeeCount(String totalEmployeeCount){
		this.totalEmployeeCount = totalEmployeeCount;
	}

	public String getTotalEmployeeCount(){
		return totalEmployeeCount;
	}

	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}

	public String getDepartmentName(){
		return departmentName;
	}

	public void setDepartmentID(String departmentID){
		this.departmentID = departmentID;
	}

	public String getDepartmentID(){
		return departmentID;
	}

	@Override
 	public String toString(){
		return 
			"DepartmentDetails{" + 
			"totalEmployeeCount = '" + totalEmployeeCount + '\'' + 
			",departmentName = '" + departmentName + '\'' + 
			",departmentID = '" + departmentID + '\'' + 
			"}";
		}
}
