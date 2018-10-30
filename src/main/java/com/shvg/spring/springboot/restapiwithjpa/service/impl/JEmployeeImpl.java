package com.shvg.spring.springboot.restapiwithjpa.service.impl;

import com.shvg.spring.basedata.entity.JEmployee;
import com.shvg.spring.springboot.restapiwithjpa.dao.springdatajparepository.JEmployeeRepository;
import com.shvg.spring.springboot.restapiwithjpa.service.JEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JEmployeeImpl implements JEmployeeService {

    @Autowired
    JEmployeeRepository jEmployeeRepository;

    //findAll
    public List<JEmployee> get() {

        return jEmployeeRepository.findAll();
    }

    //findOne
    public Optional<JEmployee> get(int employeeID) {

        return jEmployeeRepository.findById(employeeID);
    }

    //save
    public JEmployee post(JEmployee employee) {

        return jEmployeeRepository.save(employee);
    }

    //deleteOne
    public void delete(int employeeID) {

        jEmployeeRepository.deleteById(employeeID);
    }
}
