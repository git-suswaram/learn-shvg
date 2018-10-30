package com.shvg.frameworks.springboot.restapiwithjpa.dao.springdatajparepository;

import com.shvg.frameworks.springboot.basedata.entity.JDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JDepartmentRepository extends JpaRepository<JDepartment,Integer> {
}
