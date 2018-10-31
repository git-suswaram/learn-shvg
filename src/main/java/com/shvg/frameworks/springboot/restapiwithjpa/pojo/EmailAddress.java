package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

public class EmailAddress{
	private String primaryAddress;
	private String secondaryAddress;

	public void setPrimaryAddress(String primaryAddress){
		this.primaryAddress = primaryAddress;
	}

	public String getPrimaryAddress(){
		return primaryAddress;
	}

	public void setSecondaryAddress(String secondaryAddress){
		this.secondaryAddress = secondaryAddress;
	}

	public String getSecondaryAddress(){
		return secondaryAddress;
	}

	@Override
 	public String toString(){
		return 
			"EmailAddress{" + 
			"primaryAddress = '" + primaryAddress + '\'' + 
			",secondaryAddress = '" + secondaryAddress + '\'' + 
			"}";
		}
}
