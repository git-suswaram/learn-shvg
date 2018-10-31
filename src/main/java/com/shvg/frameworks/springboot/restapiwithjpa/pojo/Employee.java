package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

public class Employee{
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String displayName;
	private EmploymentDetails employmentDetails;
	private ContactInformation contactInformation;

	public void setEmploymentDetails(EmploymentDetails employmentDetails){
		this.employmentDetails = employmentDetails;
	}

	public EmploymentDetails getEmploymentDetails(){
		return employmentDetails;
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

	public void setContactInformation(ContactInformation contactInformation){
		this.contactInformation = contactInformation;
	}

	public ContactInformation getContactInformation(){
		return contactInformation;
	}

	@Override
 	public String toString(){
		return 
			"Employee{" + 
			"employmentDetails = '" + employmentDetails + '\'' + 
			",firstName = '" + firstName + '\'' + 
			",displayName = '" + displayName + '\'' + 
			",title = '" + title + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",middleName = '" + middleName + '\'' + 
			",contactInformation = '" + contactInformation + '\'' + 
			"}";
		}
}
