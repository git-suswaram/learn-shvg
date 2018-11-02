package com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo;

public class CurrentCompensation {
    private double baseSalary;
    private int minAIABonusPercentage;
    private int minAIABonusValue;

    public void setMinAIABonusPercentage(int minAIABonusPercentage) {
        this.minAIABonusPercentage = minAIABonusPercentage;
    }

    public int getMinAIABonusPercentage() {
        return minAIABonusPercentage;
    }

    public void setMinAIABonusValue(int minAIABonusValue) {
        this.minAIABonusValue = minAIABonusValue;
    }

    public int getMinAIABonusValue() {
        return minAIABonusValue;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return
                "CurrentCompensation{" +
                        "minAIABonusPercentage = '" + minAIABonusPercentage + '\'' +
                        ",minAIABonusValue = '" + minAIABonusValue + '\'' +
                        ",baseSalary = '" + baseSalary + '\'' +
                        "}";
    }
}
