package com.shvg.spring.springboot.springintegration.annotation.baseAICodeFiles.data;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

@Component
public class Person implements Comparable<Person>{
    private Integer taxID;
    private String firstName;
    private String lastName;
    private String fullName;
    private LocalDate dateOfBirth;
    private String jobTitle;
    private Double netAnnualIncome;

    public Person(Integer taxID, String firstName, String lastName, LocalDate dateOfBirth, String jobTitle, Double netAnnualIncome) {
        this.taxID = taxID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.jobTitle = jobTitle;
        this.netAnnualIncome = netAnnualIncome;
    }

    public Person() {
    }

    public Person(Integer taxID, String firstName, String lastName) {
        this.taxID = taxID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(Integer taxID, String firstName, String lastName, LocalDate dob) {
        this.taxID = taxID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth=dob;
    }

    public Integer getTaxID() {
        return taxID;
    }

    public void setTaxID(Integer taxID) {
        this.taxID = taxID;
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
    public int compareTo(Person person) {
        return lastName.compareTo(person.lastName)
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getTaxID(), person.getTaxID()) &&
                Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getDateOfBirth(), person.getDateOfBirth()) &&
                Objects.equals(getJobTitle(), person.getJobTitle()) &&
                Objects.equals(getNetAnnualIncome(), person.getNetAnnualIncome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaxID(), getFirstName(), getLastName(), getDateOfBirth(), getJobTitle(), getNetAnnualIncome());
    }

    @Override
    public String toString() {
        return "Person{" +
                "taxID=" + taxID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", jobTitle='" + jobTitle + '\'' +
                ", netAnnualIncome=" + netAnnualIncome +
                '}';
    }

}