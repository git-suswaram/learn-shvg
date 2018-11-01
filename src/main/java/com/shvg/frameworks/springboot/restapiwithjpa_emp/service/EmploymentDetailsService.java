package com.shvg.frameworks.springboot.restapiwithjpa_emp.service;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmploymentDetails;

import java.util.List;
import java.util.Optional;

public interface EmploymentDetailsService {
    List<JEEmploymentDetails> get();

    Optional<JEEmploymentDetails> get(int employeeID);

    List<JEEmploymentDetails> post(List<JEEmploymentDetails> employmentDetails);

    void delete(int employeeID);

    long count();

}
