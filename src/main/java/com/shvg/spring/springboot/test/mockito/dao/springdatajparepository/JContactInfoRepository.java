package com.shvg.spring.springboot.test.mockito.dao.springdatajparepository;

import com.shvg.spring.springboot.test.mockito.entity.JContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JContactInfoRepository extends JpaRepository<JContactInfo, Integer> {
}
