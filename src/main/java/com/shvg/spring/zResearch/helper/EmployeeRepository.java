package com.shvg.spring.zResearch.helper;

import com.shvg.spring.zResearch.beans.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Employee save(Employee employee);

    Optional<Employee> findById(Integer id);

    List<Employee> findAll();

    long count();

    void delete(Employee employee);

}
