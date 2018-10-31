package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

public class PerformanceBasedIncentivesItem{
	private String incentiveType;
	private int percentage;
	private int totalValue;

	public void setTotalValue(int totalValue){
		this.totalValue = totalValue;
	}

	public int getTotalValue(){
		return totalValue;
	}

	public void setPercentage(int percentage){
		this.percentage = percentage;
	}

	public int getPercentage(){
		return percentage;
	}

	public void setIncentiveType(String incentiveType){
		this.incentiveType = incentiveType;
	}

	public String getIncentiveType(){
		return incentiveType;
	}

	@Override
 	public String toString(){
		return 
			"PerformanceBasedIncentivesItem{" + 
			"totalValue = '" + totalValue + '\'' + 
			",percentage = '" + percentage + '\'' + 
			",incentiveType = '" + incentiveType + '\'' + 
			"}";
		}
}
