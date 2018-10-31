package com.shvg.frameworks.springboot.restapiwithjpa_emp.repository;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<JEEmployee, Integer> {
}
