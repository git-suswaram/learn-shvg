package com.shvg.spring.springboot.restapi.service;

import com.shvg.spring.springboot.restapi.beans.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> get();

    Employee get(int employeeID);

    Employee post(Employee employee);

    Employee delete(int employeeID);

}
