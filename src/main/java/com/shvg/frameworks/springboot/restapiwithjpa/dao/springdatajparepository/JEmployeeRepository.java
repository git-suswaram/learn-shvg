package com.shvg.frameworks.springboot.restapiwithjpa.dao.springdatajparepository;

import com.shvg.frameworks.springboot.basedata.entity.JEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JEmployeeRepository extends JpaRepository<JEmployee, Integer> {
}
