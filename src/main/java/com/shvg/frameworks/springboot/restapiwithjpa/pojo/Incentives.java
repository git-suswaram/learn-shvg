package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

import java.util.List;

public class Incentives{
	private int totalIncentivesValue;
	private List<FixedIncentives> fixedIncentives;
	private List<PerformanceBasedIncentives> performanceBasedIncentives;

	public void setPerformanceBasedIncentives(List<PerformanceBasedIncentives> performanceBasedIncentives){
		this.performanceBasedIncentives = performanceBasedIncentives;
	}

	public List<PerformanceBasedIncentives> getPerformanceBasedIncentives(){
		return performanceBasedIncentives;
	}

	public void setTotalIncentivesValue(int totalIncentivesValue){
		this.totalIncentivesValue = totalIncentivesValue;
	}

	public int getTotalIncentivesValue(){
		return totalIncentivesValue;
	}

	public void setFixedIncentives(List<FixedIncentives> fixedIncentives){
		this.fixedIncentives = fixedIncentives;
	}

	public List<FixedIncentives> getFixedIncentives(){
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