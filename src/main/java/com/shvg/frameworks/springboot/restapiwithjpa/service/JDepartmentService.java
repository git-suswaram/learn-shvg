package com.shvg.frameworks.springboot.restapiwithjpa.service;

import com.shvg.frameworks.springboot.basedata.entity.JDepartment;

import java.util.List;
import java.util.Optional;

public interface JDepartmentService {

    List<JDepartment> get();

    Optional<JDepartment> get(int departmentID);

    JDepartment post(JDepartment department);

    void delete(int departmentID);

}
