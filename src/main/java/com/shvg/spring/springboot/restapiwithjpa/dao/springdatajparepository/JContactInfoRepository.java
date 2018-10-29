package com.shvg.spring.springboot.restapiwithjpa.dao.springdatajparepository;

import com.shvg.spring.springboot.restapiwithjpa.entity.JContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JContactInfoRepository extends JpaRepository<JContactInfo, Integer> {
}
