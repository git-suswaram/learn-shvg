package com.shvg.spring.springboot.restapiwithjpa.dao.springdatajparepository;

import com.shvg.spring.basedata.entity.JContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JContactInfoRepository extends JpaRepository<JContactInfo, Integer> {
}
