package com.shvg.spring.springboot.test.mockito.service;

import com.shvg.spring.springboot.test.mockito.entity.JEmployee;

import java.util.List;
import java.util.Optional;

public interface JEmployeeService {

    List<com.shvg.spring.springboot.test.mockito.entity.JEmployee> get();

    Optional<com.shvg.spring.springboot.test.mockito.entity.JEmployee> get(int employeeID);

    JEmployee post(JEmployee employee);

    void delete(int employeeID);

}
