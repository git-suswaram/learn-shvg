package com.shvg.spring.springboot.restapiwithjpa.beans;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;

@Component
public class Department {

    private int id;

    @Size(min = 2, message = "Department Name should have at-least 2 characters.")
    private String departmentName;
    private int numberOfEmployees;
    private int headOfDepartmentEmpID;

    /**
     * Setter Methods and  Default no-argument constructor is required for processing REST requests
     */
    public Department() {
    }

    public Department(int id, String departmentName, int headOfDepartmentEmpID) {
        this.id = id;
        this.departmentName = departmentName;
        this.headOfDepartmentEmpID = headOfDepartmentEmpID;
    }

    public Department(String departmentName, int numberOfEmployees) {
        this.departmentName = departmentName;
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getHeadOfDepartmentEmpID() {
        return headOfDepartmentEmpID;
    }

    public void setHeadOfDepartmentEmpID(int headOfDepartmentEmpID) {
        this.headOfDepartmentEmpID = headOfDepartmentEmpID;
    }

    @Override
    public String toString() {
        return "JDepartment{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", numberOfEmployees=" + numberOfEmployees +
                ", headOfDepartmentEmpID=" + headOfDepartmentEmpID +
                '}';
    }
}
