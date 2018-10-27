package com.shvg.spring.springboot.restapi.beans;

import org.springframework.stereotype.Component;
import javax.validation.constraints.Size;

@Component
public class Department {

    private int departmentID;

    @Size(min = 2, message = "Department Name should have at-least 2 characters.")
    private String departmentName;

    //@Size(min = 4, message = "EmployeeID of departments HOD should be at-least 4 digits.")
    private int headOfDepartmentEmpID;

    /** Setter Methods and  Default no-argument constructor is required for processing REST requests */
    public Department() {
    }

    public Department(int departmentID, String departmentName, int headOfDepartmentEmpID) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.headOfDepartmentEmpID = headOfDepartmentEmpID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
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
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                ", headOfDepartmentEmpID='" + headOfDepartmentEmpID + '\'' +
                '}';
    }
}
