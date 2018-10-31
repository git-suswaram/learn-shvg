package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

public class PhysicalAddressItem{
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String addressType;

	public void setAddressLine2(String addressLine2){
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine2(){
		return addressLine2;
	}

	public void setAddressLine1(String addressLine1){
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine1(){
		return addressLine1;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}

	public String getPostalCode(){
		return postalCode;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setAddressType(String addressType){
		this.addressType = addressType;
	}

	public String getAddressType(){
		return addressType;
	}

	@Override
 	public String toString(){
		return 
			"PhysicalAddressItem{" + 
			"addressLine2 = '" + addressLine2 + '\'' + 
			",addressLine1 = '" + addressLine1 + '\'' + 
			",state = '" + state + '\'' + 
			",country = '" + country + '\'' + 
			",postalCode = '" + postalCode + '\'' + 
			",city = '" + city + '\'' + 
			",addressType = '" + addressType + '\'' + 
			"}";
		}
}
