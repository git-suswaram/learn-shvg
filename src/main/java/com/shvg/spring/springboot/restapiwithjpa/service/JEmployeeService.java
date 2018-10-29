package com.shvg.spring.springboot.restapiwithjpa.service;

import com.shvg.spring.springboot.restapiwithjpa.entity.JEmployee;

import java.util.List;
import java.util.Optional;

public interface JEmployeeService {

    List<JEmployee> get();

    Optional<JEmployee> get(int employeeID);

    JEmployee post(JEmployee employee);

    void delete(int employeeID);

}
