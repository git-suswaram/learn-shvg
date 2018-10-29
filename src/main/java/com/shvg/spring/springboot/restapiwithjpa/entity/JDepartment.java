package com.shvg.spring.springboot.restapiwithjpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String departmentName;
    private int numberOfEmployees;
    private int headOfDepartmentEmpID;

    /**
     * Setter Methods and  Default no-argument constructor is required for JPA
     */
    public JDepartment() {
    }

    public JDepartment(int id, String departmentName, int headOfDepartmentEmpID) {
        this.id = id;
        this.departmentName = departmentName;
        this.headOfDepartmentEmpID = headOfDepartmentEmpID;
    }

    public JDepartment(String departmentName, int numberOfEmployees) {
        this.departmentName = departmentName;
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
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
