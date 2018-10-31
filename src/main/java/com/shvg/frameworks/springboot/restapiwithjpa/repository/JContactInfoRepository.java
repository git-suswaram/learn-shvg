package com.shvg.frameworks.springboot.restapiwithjpa.repository;

import com.shvg.frameworks.springboot.restapiwithjpa.entity.JContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JContactInfoRepository extends JpaRepository<JContactInfo, Integer> {
}
