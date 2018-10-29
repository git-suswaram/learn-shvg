package com.shvg.spring.springboot.restapiwithjpa.service.impl;

import com.shvg.spring.springboot.restapiwithjpa.dao.springdatajparepository.JDepartmentRepository;
import com.shvg.spring.springboot.restapiwithjpa.entity.JDepartment;
import com.shvg.spring.springboot.restapiwithjpa.service.JDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JDepartmentImpl implements JDepartmentService {

    @Autowired
    JDepartmentRepository jDepartmentRepository;

    //findAll
    public List<JDepartment> get() {

        return jDepartmentRepository.findAll();
    }

    //findOne
    public Optional<JDepartment> get(int departmentID) {

        return jDepartmentRepository.findById(departmentID);
    }

    //save
    public JDepartment post(JDepartment department) {

        return jDepartmentRepository.save(department);
    }

    //deleteOne
    public void delete(int departmentID) throws EmptyResultDataAccessException {

        jDepartmentRepository.deleteById(departmentID);
    }
}
