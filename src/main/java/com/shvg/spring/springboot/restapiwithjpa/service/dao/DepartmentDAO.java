package com.shvg.spring.springboot.restapiwithjpa.service.dao;

import com.shvg.spring.springboot.restapiwithjpa.basedata.DepartmentData;
import com.shvg.spring.springboot.restapiwithjpa.beans.Department;
import com.shvg.spring.springboot.restapiwithjpa.service.DepartmentService;
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
            if (department.getId() == departmentID) {
                return department;
            }
        }

        return null;
    }

    //save
    public Department post(Department department) {

        if (department.getId() == 0) {
            department.setId(++departmentCount);
        }
        DepartmentData.getMutableListOfDepartments().add(department);
        return department;
    }

    //deleteOne
    public Department delete(int departmentID) {

        Iterator<Department> iterator = DepartmentData.getMutableListOfDepartments().iterator();

        while (iterator.hasNext()) {
            Department department = iterator.next();
            if (department.getId() == departmentID) {
                iterator.remove();
                return department;
            }
        }
        return null;
    }
}
