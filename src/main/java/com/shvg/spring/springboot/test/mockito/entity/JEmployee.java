package com.shvg.spring.springboot.test.mockito.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Component
@Entity
@JsonFilter("FilterEmployeeInfo")
public class JEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Size(min = 2, message = "FirstName should have minimum of 2 characters")
    private String firstName;
    private String lastName;
    private String fullName;
    @Past(message = "Date of Birth should be either current day or in the past")
    private LocalDate dateOfBirth;
    private String department;
    private String jobTitle;
    private Double netAnnualIncome;

    /**
     * Default no-argument constructor is required for JPA
     */
    public JEmployee() {
    }

    public JEmployee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public JEmployee(String firstName, String lastName, LocalDate dateOfBirth, String department, String jobTitle, Double netAnnualIncome) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.jobTitle = jobTitle;
        this.netAnnualIncome = netAnnualIncome;
    }

    public int getId() {
        return id;
    }

    public void setId(int employeeID) {
        this.id = employeeID;
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

    public int compareTo(JEmployee employee) {
        return lastName.compareTo(employee.lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JEmployee employee = (JEmployee) o;
        return Objects.equals(getId(), employee.getId()) &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName()) &&
                Objects.equals(getDateOfBirth(), employee.getDateOfBirth()) &&
                Objects.equals(getJobTitle(), employee.getJobTitle()) &&
                Objects.equals(getNetAnnualIncome(), employee.getNetAnnualIncome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getDateOfBirth(), getJobTitle(), getNetAnnualIncome());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", jobTitle='" + jobTitle + '\'' +
                ", netAnnualIncome=" + netAnnualIncome +
                '}';
    }

}