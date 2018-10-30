package com.shvg.frameworks.springboot.restapiwithjpa.dao.jpa;

import com.shvg.frameworks.springboot.basedata.entity.JDepartment;

import java.util.List;

public interface JDepartmentService {

    List<JDepartment> get();

    JDepartment get(int departmentID);

    JDepartment post(JDepartment department);

    JDepartment delete(int departmentID);

}