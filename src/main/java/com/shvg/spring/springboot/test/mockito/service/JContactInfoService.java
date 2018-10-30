package com.shvg.spring.springboot.test.mockito.service;

import com.shvg.spring.springboot.test.mockito.entity.JContactInfo;

import java.util.List;
import java.util.Optional;

public interface JContactInfoService {

    List<JContactInfo> get();

    Optional<JContactInfo> get(int contactInfoID);

    JContactInfo post(JContactInfo contactInfo);

    void delete(int contactInfoID);

}
