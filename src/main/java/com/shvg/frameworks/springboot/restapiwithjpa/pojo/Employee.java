package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

import java.util.List;

public class Employee{
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String displayName;
	private EmploymentDetails employmentDetails;
	private List<EmploymentHistoryItem> employmentHistory;
	private List<YearlyRatingsItem> yearlyRatings;
	private CompensationDetails compensationDetails;

	public void setEmploymentDetails(EmploymentDetails employmentDetails){
		this.employmentDetails = employmentDetails;
	}

	public EmploymentDetails getEmploymentDetails(){
		return employmentDetails;
	}

	public void setEmploymentHistory(List<EmploymentHistoryItem> employmentHistory){
		this.employmentHistory = employmentHistory;
	}

	public List<EmploymentHistoryItem> getEmploymentHistory(){
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

	public void setYearlyRatings(List<YearlyRatingsItem> yearlyRatings){
		this.yearlyRatings = yearlyRatings;
	}

	public List<YearlyRatingsItem> getYearlyRatings(){
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