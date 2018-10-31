package com.shvg.frameworks.springboot.restapiwithjpa_emp.service.impl;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.repository.EmployeeRepository;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //findAll
    @Override
    public List<JEEmployee> get() {

        return employeeRepository.findAll();
    }

    //findOne
    @Override
    public Optional<JEEmployee> get(int employeeID) {

        return employeeRepository.findById(employeeID);
    }

    @Override
    public List<JEEmployee> post(List<JEEmployee> jeEmployeeList) {

        for(JEEmployee jeEmployee : jeEmployeeList){
            employeeRepository.save(jeEmployee);
        }
        return jeEmployeeList;
    }

    //deleteOne
    @Override
    public void delete(int employeeID) {

        employeeRepository.deleteById(employeeID);
    }

    @Override
    public long count() {
        return employeeRepository.count();
    }
}
