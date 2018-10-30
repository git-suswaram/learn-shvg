package com.shvg.spring.springboot.restapiwithjpa.dao.springdatajparepository;

import com.shvg.spring.basedata.entity.JPrimitiveType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPrimitiveDataRepository extends JpaRepository<JPrimitiveType, Integer> {
}
