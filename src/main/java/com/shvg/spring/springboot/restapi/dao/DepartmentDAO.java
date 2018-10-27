package com.shvg.spring.springboot.restapi.dao;

import com.shvg.spring.springboot.restapi.beans.Department;
import com.shvg.spring.springboot.restapi.service.DepartmentService;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

import static com.shvg.spring.springboot.restapi.baseData.DepartmentData.mutableListOfDepartments;


@Component
public class DepartmentDAO implements DepartmentService {

    private int departmentCount = mutableListOfDepartments.size();

    //findAll
    public List<Department> get() {
        return mutableListOfDepartments;
    }

    //findOne
    public Department get(int departmentID) {

        for (Department department : mutableListOfDepartments) {
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
        mutableListOfDepartments.add(department);
        return department;
    }

    //deleteOne
    public Department delete(int departmentID) {

        Iterator<Department> iterator = mutableListOfDepartments.iterator();

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
