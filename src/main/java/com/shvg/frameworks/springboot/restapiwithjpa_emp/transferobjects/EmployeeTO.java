package com.shvg.frameworks.springboot.restapiwithjpa_emp.transferobjects;

import org.springframework.stereotype.Component;

@Component

public class EmployeeTO {

    private String employeeId;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String displayName;

    public EmployeeTO() {
    }

    public EmployeeTO(String employeeId, String title, String firstName, String middleName, String lastName, String displayName) {
        this.employeeId = employeeId;
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.displayName = displayName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "EmployeeTO{" +
                "employeeId='" + employeeId + '\'' +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
