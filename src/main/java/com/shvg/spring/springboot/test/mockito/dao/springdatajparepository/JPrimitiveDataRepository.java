package com.shvg.spring.springboot.test.mockito.dao.springdatajparepository;

import com.shvg.spring.springboot.test.mockito.entity.JPrimitiveData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPrimitiveDataRepository extends JpaRepository<JPrimitiveData, Integer> {
}
