package com.shvg.frameworks.springboot.restapiwithjpa.dao.springdatajparepository;

import com.shvg.frameworks.springboot.basedata.entity.JPrimitiveType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPrimitiveDataRepository extends JpaRepository<JPrimitiveType, Integer> {
}
