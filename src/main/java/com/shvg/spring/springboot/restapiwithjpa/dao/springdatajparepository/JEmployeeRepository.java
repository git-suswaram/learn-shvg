package com.shvg.spring.springboot.restapiwithjpa.dao.springdatajparepository;

import com.shvg.spring.basedata.entity.JEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JEmployeeRepository extends JpaRepository<JEmployee, Integer> {
}
