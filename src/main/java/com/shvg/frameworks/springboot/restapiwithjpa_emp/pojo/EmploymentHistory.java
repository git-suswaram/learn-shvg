package com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo;

public class EmploymentHistory {
    private String employmentStartDate;
    private String employmentEndDate;
    private String jobTitle;
    private DepartmentDetails departmentDetails;

    public void setEmploymentEndDate(String employmentEndDate) {
        this.employmentEndDate = employmentEndDate;
    }

    public String getEmploymentEndDate() {
        return employmentEndDate;
    }

    public void setDepartmentDetails(DepartmentDetails departmentDetails) {
        this.departmentDetails = departmentDetails;
    }

    public DepartmentDetails getDepartmentDetails() {
        return departmentDetails;
    }

    public void setEmploymentStartDate(String employmentStartDate) {
        this.employmentStartDate = employmentStartDate;
    }

    public String getEmploymentStartDate() {
        return employmentStartDate;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String toString() {
        return
                "EmploymentHistory{" +
                        "employmentEndDate = '" + employmentEndDate + '\'' +
                        ",departmentDetails = '" + departmentDetails + '\'' +
                        ",employmentStartDate = '" + employmentStartDate + '\'' +
                        ",jobTitle = '" + jobTitle + '\'' +
                        "}";
    }
}
