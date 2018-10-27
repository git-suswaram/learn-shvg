package com.shvg.spring.springboot.restapi.service;

import com.shvg.spring.springboot.restapi.beans.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> get();

    Department get(int departmentID);

    Department post(Department department);

    Department delete(int departmentID);

}
