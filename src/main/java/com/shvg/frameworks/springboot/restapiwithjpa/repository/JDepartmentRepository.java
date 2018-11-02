package com.shvg.frameworks.springboot.restapiwithjpa.repository;

import com.shvg.frameworks.springboot.restapiwithjpa.entity.JDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JDepartmentRepository extends JpaRepository<JDepartment, Integer> {
}
