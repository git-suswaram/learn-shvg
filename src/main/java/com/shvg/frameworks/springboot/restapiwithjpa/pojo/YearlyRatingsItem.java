package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

public class YearlyRatingsItem{
	private String year;
	private String goal;
	private String leadership;

	public void setLeadership(String leadership){
		this.leadership = leadership;
	}

	public String getLeadership(){
		return leadership;
	}

	public void setGoal(String goal){
		this.goal = goal;
	}

	public String getGoal(){
		return goal;
	}

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	@Override
 	public String toString(){
		return 
			"YearlyRatingsItem{" + 
			"leadership = '" + leadership + '\'' + 
			",goal = '" + goal + '\'' + 
			",year = '" + year + '\'' + 
			"}";
		}
}
