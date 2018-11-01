package com.shvg.frameworks.springboot.restapiwithjpa_emp.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Entity
public class JEEmploymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int employmentDetailId;
    private String employeeId;
    private String jobTitle;
    private String employeeType;
    private String employmentStatus;
    private String firstHireDate;
    private String recentHireDate;
    private int departmentID;

    public JEEmploymentDetails() {
    }

    public int getEmploymentDetailId() {
        return employmentDetailId;
    }

    public void setEmploymentDetailId(int employmentDetailId) {
        this.employmentDetailId = employmentDetailId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getFirstHireDate() {
        return firstHireDate;
    }

    public void setFirstHireDate(String firstHireDate) {
        this.firstHireDate = firstHireDate;
    }

    public String getRecentHireDate() {
        return recentHireDate;
    }

    public void setRecentHireDate(String recentHireDate) {
        this.recentHireDate = recentHireDate;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {
        return "JEEmploymentDetails{" +
                "employmentDetailId='" + employmentDetailId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", firstHireDate=" + firstHireDate +
                ", recentHireDate=" + recentHireDate +
                ", departmentID=" + departmentID +
                '}';
    }
}
