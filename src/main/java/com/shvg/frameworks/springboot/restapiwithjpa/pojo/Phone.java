package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

public class Phone{
	private String workPhone;
	private String mobilePhone;
	private String homePhone;

	public void setWorkPhone(String workPhone){
		this.workPhone = workPhone;
	}

	public String getWorkPhone(){
		return workPhone;
	}

	public void setHomePhone(String homePhone){
		this.homePhone = homePhone;
	}

	public String getHomePhone(){
		return homePhone;
	}

	public void setMobilePhone(String mobilePhone){
		this.mobilePhone = mobilePhone;
	}

	public String getMobilePhone(){
		return mobilePhone;
	}

	@Override
 	public String toString(){
		return 
			"Phone{" + 
			"workPhone = '" + workPhone + '\'' + 
			",homePhone = '" + homePhone + '\'' + 
			",mobilePhone = '" + mobilePhone + '\'' + 
			"}";
		}
}
