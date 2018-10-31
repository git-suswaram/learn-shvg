package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

import java.util.List;

public class CompensationDetails{
	private CurrentCompensation currentCompensation;
	private List<CompensationHistoryItem> compensationHistory;

	public void setCurrentCompensation(CurrentCompensation currentCompensation){
		this.currentCompensation = currentCompensation;
	}

	public CurrentCompensation getCurrentCompensation(){
		return currentCompensation;
	}

	public void setCompensationHistory(List<CompensationHistoryItem> compensationHistory){
		this.compensationHistory = compensationHistory;
	}

	public List<CompensationHistoryItem> getCompensationHistory(){
		return compensationHistory;
	}

	@Override
 	public String toString(){
		return 
			"CompensationDetails{" + 
			"currentCompensation = '" + currentCompensation + '\'' + 
			",compensationHistory = '" + compensationHistory + '\'' + 
			"}";
		}
}