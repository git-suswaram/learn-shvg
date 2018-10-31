package com.shvg.frameworks.springboot.restapiwithjpa.repository;

import com.shvg.frameworks.springboot.restapiwithjpa.entity.JEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JEmployeeRepository extends JpaRepository<JEmployee, Integer> {
}
