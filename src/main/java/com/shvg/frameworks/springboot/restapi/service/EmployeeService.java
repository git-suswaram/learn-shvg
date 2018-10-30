package com.shvg.frameworks.springboot.restapi.service;

import com.shvg.frameworks.springboot.restapi.beans.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> get();

    Employee get(int employeeID);

    Employee post(Employee employee);

    Employee delete(int employeeID);

}
