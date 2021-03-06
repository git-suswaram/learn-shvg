package com.shvg.spring.springboot.zResearch.beans;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

@Component
public class Employee implements Comparable<Employee>{
    private int employeeID;
    private String firstName;
    private String lastName;
    private String fullName;
    private LocalDate dateOfBirth;
    private String department;
    private String jobTitle;
    private Double netAnnualIncome;


    /** Setter Methods and  Default no-argument constructor is required for processing REST requests */
    public Employee() {
    }

    public Employee(int employeeID, String firstName, String lastName) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(int employeeID, String firstName, String lastName, LocalDate dateOfBirth) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth=dateOfBirth;
    }

    public Employee(int employeeID, String firstName, String lastName, String department) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public Employee(int employeeID, String firstName, String lastName, LocalDate dateOfBirth, String department, String jobTitle) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.jobTitle = jobTitle;
    }

    public Employee(int employeeID, String firstName, String lastName, LocalDate dateOfBirth, String department, String jobTitle, Double netAnnualIncome) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.jobTitle = jobTitle;
        this.netAnnualIncome = netAnnualIncome;
    }


    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getNetAnnualIncome() {
        return netAnnualIncome;
    }

    public void setNetAnnualIncome(Double netAnnualIncome) {
        this.netAnnualIncome = netAnnualIncome;
    }


    public void annualNetIncomeIncrement(Double percentage) {
        Double newNetAnnualIncome = netAnnualIncome + percentage * netAnnualIncome / 100;
        setNetAnnualIncome(newNetAnnualIncome);
    }

    @Override
    public int compareTo(Employee employee) {
        return lastName.compareTo(employee.lastName)
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getEmployeeID(), employee.getEmployeeID()) &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName()) &&
                Objects.equals(getDateOfBirth(), employee.getDateOfBirth()) &&
                Objects.equals(getJobTitle(), employee.getJobTitle()) &&
                Objects.equals(getNetAnnualIncome(), employee.getNetAnnualIncome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeID(), getFirstName(), getLastName(), getDateOfBirth(), getJobTitle(), getNetAnnualIncome());
    }

    @Override
    public String toString() {
        return "Person{" +
                "employeeID=" + employeeID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", jobTitle='" + jobTitle + '\'' +
                ", netAnnualIncome=" + netAnnualIncome +
                '}';
    }

}