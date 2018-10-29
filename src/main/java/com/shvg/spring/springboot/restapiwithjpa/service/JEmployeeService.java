package com.shvg.spring.springboot.restapiwithjpa.service;

import com.shvg.spring.springboot.restapiwithjpa.entity.JEmployee;

import java.util.List;

public interface JEmployeeService {

    List<JEmployee> get();

    JEmployee get(int employeeID);

    JEmployee post(JEmployee employee);

    JEmployee delete(int employeeID);

}
