package com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo;

public class YearlyRatings {
    private int year;
    private String goal;
    private String leadership;

    public void setLeadership(String leadership) {
        this.leadership = leadership;
    }

    public String getLeadership() {
        return leadership;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getGoal() {
        return goal;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return
                "YearlyRatings{" +
                        "leadership = '" + leadership + '\'' +
                        ",goal = '" + goal + '\'' +
                        ",year = '" + year + '\'' +
                        "}";
    }
}
