package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

import java.util.List;

public class ContactInformation{
	private EmailAddress emailAddress;
	private Phone phone;
	private List<PhysicalAddressItem> physicalAddress;

	public void setPhone(Phone phone){
		this.phone = phone;
	}

	public Phone getPhone(){
		return phone;
	}

	public void setPhysicalAddress(List<PhysicalAddressItem> physicalAddress){
		this.physicalAddress = physicalAddress;
	}

	public List<PhysicalAddressItem> getPhysicalAddress(){
		return physicalAddress;
	}

	public void setEmailAddress(EmailAddress emailAddress){
		this.emailAddress = emailAddress;
	}

	public EmailAddress getEmailAddress(){
		return emailAddress;
	}

	@Override
 	public String toString(){
		return 
			"ContactInformation{" + 
			"phone = '" + phone + '\'' + 
			",physicalAddress = '" + physicalAddress + '\'' + 
			",emailAddress = '" + emailAddress + '\'' + 
			"}";
		}
}