package com.shvg.frameworks.springboot.restapiwithjpa.repository;

import com.shvg.frameworks.springboot.restapiwithjpa.entity.JPrimitiveType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPrimitiveDataRepository extends JpaRepository<JPrimitiveType, Integer> {
}
