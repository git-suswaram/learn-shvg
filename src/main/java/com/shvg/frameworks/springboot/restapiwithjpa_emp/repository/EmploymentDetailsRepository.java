package com.shvg.frameworks.springboot.restapiwithjpa_emp.repository;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmploymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentDetailsRepository extends JpaRepository<JEEmploymentDetails, Integer> {
}
