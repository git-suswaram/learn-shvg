package com.shvg.frameworks.springboot.restapiwithjpa_emp.service;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {


    List<JEEmployee> get();

    Optional<JEEmployee> get(int employeeID);

    List<JEEmployee> post(List<JEEmployee> employee);

    void delete(int employeeID);

    long count();

}
