package com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo;

public class EmploymentDetails {
    private String employeeId;
    private String jobTitle;
    private String employeeType;
    private String employmentStatus;
    private int departmentID;
    private String departmentName;
    private String firstHireDate;
    private String rehireDate;

    public void setFirstHireDate(String firstHireDate) {
        this.firstHireDate = firstHireDate;
    }

    public String getFirstHireDate() {
        return firstHireDate;
    }

    public void setRehireDate(String rehireDate) {
        this.rehireDate = rehireDate;
    }

    public String getRehireDate() {
        return rehireDate;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    @Override
    public String toString() {
        return
                "EmploymentDetails{" +
                        "firstHireDate = '" + firstHireDate + '\'' +
                        ",rehireDate = '" + rehireDate + '\'' +
                        ",employmentStatus = '" + employmentStatus + '\'' +
                        ",departmentName = '" + departmentName + '\'' +
                        ",departmentID = '" + departmentID + '\'' +
                        ",employeeId = '" + employeeId + '\'' +
                        ",jobTitle = '" + jobTitle + '\'' +
                        ",employeeType = '" + employeeType + '\'' +
                        "}";
    }
}
