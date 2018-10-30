package com.shvg.spring.springboot.test.mockito.dao.springdatajparepository;

import com.shvg.spring.springboot.test.mockito.entity.JEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JEmployeeRepository extends JpaRepository<JEmployee, Integer> {
}
