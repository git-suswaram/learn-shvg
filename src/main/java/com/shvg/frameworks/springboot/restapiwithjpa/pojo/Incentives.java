package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

import java.util.List;

public class Incentives{
	private int totalIncentivesValue;
	private List<FixedIncentivesItem> fixedIncentives;
	private List<PerformanceBasedIncentivesItem> performanceBasedIncentives;

	public void setPerformanceBasedIncentives(List<PerformanceBasedIncentivesItem> performanceBasedIncentives){
		this.performanceBasedIncentives = performanceBasedIncentives;
	}

	public List<PerformanceBasedIncentivesItem> getPerformanceBasedIncentives(){
		return performanceBasedIncentives;
	}

	public void setTotalIncentivesValue(int totalIncentivesValue){
		this.totalIncentivesValue = totalIncentivesValue;
	}

	public int getTotalIncentivesValue(){
		return totalIncentivesValue;
	}

	public void setFixedIncentives(List<FixedIncentivesItem> fixedIncentives){
		this.fixedIncentives = fixedIncentives;
	}

	public List<FixedIncentivesItem> getFixedIncentives(){
		return fixedIncentives;
	}

	@Override
 	public String toString(){
		return 
			"Incentives{" + 
			"performanceBasedIncentives = '" + performanceBasedIncentives + '\'' + 
			",totalIncentivesValue = '" + totalIncentivesValue + '\'' + 
			",fixedIncentives = '" + fixedIncentives + '\'' + 
			"}";
		}
}