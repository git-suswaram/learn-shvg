package com.shvg.frameworks.springboot.restapiwithjpa.pojo;

public class CompensationHistoryItem{
	private int year;
	private int startingSalary;
	private int salaryIncrementPercentage;
	private int salaryIncrementValue;
	private int totalYearlyIncome;
	private Incentives incentives;

	public void setSalaryIncrementValue(int salaryIncrementValue){
		this.salaryIncrementValue = salaryIncrementValue;
	}

	public int getSalaryIncrementValue(){
		return salaryIncrementValue;
	}

	public void setIncentives(Incentives incentives){
		this.incentives = incentives;
	}

	public Incentives getIncentives(){
		return incentives;
	}

	public void setYear(int year){
		this.year = year;
	}

	public int getYear(){
		return year;
	}

	public void setTotalYearlyIncome(int totalYearlyIncome){
		this.totalYearlyIncome = totalYearlyIncome;
	}

	public int getTotalYearlyIncome(){
		return totalYearlyIncome;
	}

	public void setSalaryIncrementPercentage(int salaryIncrementPercentage){
		this.salaryIncrementPercentage = salaryIncrementPercentage;
	}

	public int getSalaryIncrementPercentage(){
		return salaryIncrementPercentage;
	}

	public void setStartingSalary(int startingSalary){
		this.startingSalary = startingSalary;
	}

	public int getStartingSalary(){
		return startingSalary;
	}

	@Override
 	public String toString(){
		return 
			"CompensationHistoryItem{" + 
			"salaryIncrementValue = '" + salaryIncrementValue + '\'' + 
			",incentives = '" + incentives + '\'' + 
			",year = '" + year + '\'' + 
			",totalYearlyIncome = '" + totalYearlyIncome + '\'' + 
			",salaryIncrementPercentage = '" + salaryIncrementPercentage + '\'' + 
			",startingSalary = '" + startingSalary + '\'' + 
			"}";
		}
}
