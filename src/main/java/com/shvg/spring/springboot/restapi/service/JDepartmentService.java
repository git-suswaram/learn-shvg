package com.shvg.spring.springboot.restapi.service;

import com.shvg.spring.springboot.restapi.entity.JDepartment;

import java.util.List;

public interface JDepartmentService {

    List<JDepartment> get();

    JDepartment get(int departmentID);

    JDepartment post(JDepartment department);

    JDepartment delete(int departmentID);

}
