package com.shvg.frameworks.springboot.restapiwithjpa_emp.service.impl;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmploymentDetails;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.repository.EmploymentDetailsRepository;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.service.EmploymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDetailsServiceImpl implements EmploymentDetailsService {

    @Autowired
    EmploymentDetailsRepository employmentDetailsRepository;

    //findAll
    @Override
    public List<JEEmploymentDetails> get() {

        return employmentDetailsRepository.findAll();
    }

    //findOne
    @Override
    public Optional<JEEmploymentDetails> get(int employeeID) {

        return employmentDetailsRepository.findById(employeeID);
    }

    @Override
    public List<JEEmploymentDetails> post(List<JEEmploymentDetails> jeEmploymentDetails) {

        employmentDetailsRepository.saveAll(jeEmploymentDetails);
        return jeEmploymentDetails;
    }

    //deleteOne
    @Override
    public void delete(int employeeID) {

        employmentDetailsRepository.deleteById(employeeID);
    }

    @Override
    public long count() {
        return employmentDetailsRepository.count();
    }
}
