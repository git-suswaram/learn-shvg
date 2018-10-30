package com.shvg.frameworks.springboot.restapiwithjpa.service;

import com.shvg.frameworks.springboot.basedata.entity.JEmployee;

import java.util.List;
import java.util.Optional;

public interface JEmployeeService {

    List<JEmployee> get();

    Optional<JEmployee> get(int employeeID);

    JEmployee post(JEmployee employee);

    void delete(int employeeID);

}
