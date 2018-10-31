package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

import java.util.List;

public class EmploymentDetails{
	private String employeeId;
	private String jobTitle;
	private String employeeType;
	private String employmentStatus;
	private String firstHireDate;
	private String latestHireDate;
	private DepartmentDetails departmentDetails;
	private List<YearlyRatingsItem> yearlyRatings;

	public void setFirstHireDate(String firstHireDate){
		this.firstHireDate = firstHireDate;
	}

	public String getFirstHireDate(){
		return firstHireDate;
	}

	public void setDepartmentDetails(DepartmentDetails departmentDetails){
		this.departmentDetails = departmentDetails;
	}

	public DepartmentDetails getDepartmentDetails(){
		return departmentDetails;
	}

	public void setLatestHireDate(String latestHireDate){
		this.latestHireDate = latestHireDate;
	}

	public String getLatestHireDate(){
		return latestHireDate;
	}

	public void setTitle(String jobTitle){
		this.jobTitle = jobTitle;
	}

	public String getTitle(){
		return jobTitle;
	}

	public void setEmploymentStatus(String employmentStatus){
		this.employmentStatus = employmentStatus;
	}

	public String getEmploymentStatus(){
		return employmentStatus;
	}

	public void setYearlyRatings(List<YearlyRatingsItem> yearlyRatings){
		this.yearlyRatings = yearlyRatings;
	}

	public List<YearlyRatingsItem> getYearlyRatings(){
		return yearlyRatings;
	}

	public void setEmployeeId(String employeeId){
		this.employeeId = employeeId;
	}

	public String getEmployeeId(){
		return employeeId;
	}

	public void setEmployeeType(String employeeType){
		this.employeeType = employeeType;
	}

	public String getEmployeeType(){
		return employeeType;
	}

	@Override
 	public String toString(){
		return 
			"EmploymentDetails{" + 
			"firstHireDate = '" + firstHireDate + '\'' + 
			",departmentDetails = '" + departmentDetails + '\'' + 
			",latestHireDate = '" + latestHireDate + '\'' + 
			",jobTitle = '" + jobTitle + '\'' +
			",employmentStatus = '" + employmentStatus + '\'' + 
			",yearlyRatings = '" + yearlyRatings + '\'' + 
			",employeeId = '" + employeeId + '\'' + 
			",employeeType = '" + employeeType + '\'' + 
			"}";
		}
}