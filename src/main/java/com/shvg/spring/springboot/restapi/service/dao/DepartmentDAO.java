package com.shvg.spring.springboot.restapi.service.dao;

import com.shvg.spring.springboot.restapi.basedata.DepartmentData;
import com.shvg.spring.springboot.restapi.beans.Department;
import com.shvg.spring.springboot.restapi.service.DepartmentService;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;


@Component
public class DepartmentDAO implements DepartmentService {

    private int departmentCount = DepartmentData.getMutableListOfDepartments().size();

    //findAll
    public List<Department> get() {
        return DepartmentData.getMutableListOfDepartments();
    }

    //findOne
    public Department get(int departmentID) {

        for (Department department : DepartmentData.getMutableListOfDepartments()) {
            if (department.getDepartmentID() == departmentID) {
                return department;
            }
        }

        return null;
    }

    //save
    public Department post(Department department) {

        if (department.getDepartmentID() == 0) {
            department.setDepartmentID(++departmentCount);
        }
        DepartmentData.getMutableListOfDepartments().add(department);
        return department;
    }

    //deleteOne
    public Department delete(int departmentID) {

        Iterator<Department> iterator = DepartmentData.getMutableListOfDepartments().iterator();

        while (iterator.hasNext()) {
            Department department = iterator.next();
            if (department.getDepartmentID() == departmentID) {
                iterator.remove();
                return department;
            }
        }
        return null;
    }
}
