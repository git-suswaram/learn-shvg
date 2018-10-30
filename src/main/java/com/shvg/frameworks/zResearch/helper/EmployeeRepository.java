package com.shvg.frameworks.zResearch.helper;

import com.shvg.frameworks.zResearch.beans.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Employee save(Employee employee);

    Optional<Employee> findById(Integer id);

    List<Employee> findAll();

    long count();

    void delete(Employee employee);

}