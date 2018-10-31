package com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo;

import java.util.List;

public class Employee{
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String displayName;
	private EmploymentDetails employmentDetails;
	private List<EmploymentHistory> employmentHistory;
	private List<YearlyRatings> yearlyRatings;
	private CompensationDetails compensationDetails;

	public void setEmploymentDetails(EmploymentDetails employmentDetails){
		this.employmentDetails = employmentDetails;
	}

	public EmploymentDetails getEmploymentDetails(){
		return employmentDetails;
	}

	public void setEmploymentHistory(List<EmploymentHistory> employmentHistory){
		this.employmentHistory = employmentHistory;
	}

	public List<EmploymentHistory> getEmploymentHistory(){
		return employmentHistory;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setYearlyRatings(List<YearlyRatings> yearlyRatings){
		this.yearlyRatings = yearlyRatings;
	}

	public List<YearlyRatings> getYearlyRatings(){
		return yearlyRatings;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setMiddleName(String middleName){
		this.middleName = middleName;
	}

	public String getMiddleName(){
		return middleName;
	}

	public void setCompensationDetails(CompensationDetails compensationDetails){
		this.compensationDetails = compensationDetails;
	}

	public CompensationDetails getCompensationDetails(){
		return compensationDetails;
	}

	@Override
 	public String toString(){
		return 
			"Employee{" + 
			"employmentDetails = '" + employmentDetails + '\'' + 
			",employmentHistory = '" + employmentHistory + '\'' + 
			",firstName = '" + firstName + '\'' + 
			",displayName = '" + displayName + '\'' + 
			",title = '" + title + '\'' + 
			",yearlyRatings = '" + yearlyRatings + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",middleName = '" + middleName + '\'' + 
			",compensationDetails = '" + compensationDetails + '\'' + 
			"}";
		}
}