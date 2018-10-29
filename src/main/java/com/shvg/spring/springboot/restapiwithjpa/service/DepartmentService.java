package com.shvg.spring.springboot.restapiwithjpa.service;

import com.shvg.spring.springboot.restapiwithjpa.beans.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> get();

    Department get(int departmentID);

    Department post(Department department);

    Department delete(int departmentID);

}
