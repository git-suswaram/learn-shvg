package com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo;

public class FixedIncentives {
    private String incentiveType;
    private int percentage;
    private int totalValue;

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setIncentiveType(String incentiveType) {
        this.incentiveType = incentiveType;
    }

    public String getIncentiveType() {
        return incentiveType;
    }

    @Override
    public String toString() {
        return
                "FixedIncentives{" +
                        "totalValue = '" + totalValue + '\'' +
                        ",percentage = '" + percentage + '\'' +
                        ",incentiveType = '" + incentiveType + '\'' +
                        "}";
    }
}
