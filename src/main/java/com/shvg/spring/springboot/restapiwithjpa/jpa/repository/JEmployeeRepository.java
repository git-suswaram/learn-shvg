package com.shvg.spring.springboot.restapiwithjpa.jpa.repository;

import com.shvg.spring.springboot.restapiwithjpa.entity.JEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JEmployeeRepository extends JpaRepository<JEmployee, Integer> {
}
