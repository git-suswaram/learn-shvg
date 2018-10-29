package com.shvg.spring.springboot.restapiwithjpa.jpa;

import com.shvg.spring.springboot.restapiwithjpa.entity.JDepartment;

import java.util.List;

public interface JDepartmentService {

    List<JDepartment> get();

    JDepartment get(int departmentID);

    JDepartment post(JDepartment department);

    JDepartment delete(int departmentID);

}
