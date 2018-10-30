package com.shvg.frameworks.springboot.restapiwithjpa.dao.springdatajparepository;

import com.shvg.frameworks.springboot.basedata.entity.JContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JContactInfoRepository extends JpaRepository<JContactInfo, Integer> {
}
