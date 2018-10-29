package com.shvg.spring.springboot.restapiwithjpa.jpa.repository;

import com.shvg.spring.springboot.restapiwithjpa.entity.JDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JDepartmentRepository extends JpaRepository<JDepartment,Integer> {
}
