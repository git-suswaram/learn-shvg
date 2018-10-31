package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

public class DepartmentDetails{
	private int departmentID;
	private String departmentName;

	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}

	public String getDepartmentName(){
		return departmentName;
	}

	public void setDepartmentID(int departmentID){
		this.departmentID = departmentID;
	}

	public int getDepartmentID(){
		return departmentID;
	}

	@Override
 	public String toString(){
		return 
			"DepartmentDetails{" + 
			"departmentName = '" + departmentName + '\'' + 
			",departmentID = '" + departmentID + '\'' + 
			"}";
		}
}
