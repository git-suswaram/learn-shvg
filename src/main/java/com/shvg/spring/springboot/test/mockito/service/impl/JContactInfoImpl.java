package com.shvg.spring.springboot.test.mockito.service.impl;

import com.shvg.spring.springboot.test.mockito.dao.springdatajparepository.JContactInfoRepository;
import com.shvg.spring.springboot.test.mockito.entity.JContactInfo;
import com.shvg.spring.springboot.test.mockito.service.JContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JContactInfoImpl implements JContactInfoService {

    @Autowired
    JContactInfoRepository jContactInfoRepository;

    //findAll
    public List<JContactInfo> get() {

        return jContactInfoRepository.findAll();
    }

    //findOne
    public Optional<JContactInfo> get(int contactInfoID) {

        return jContactInfoRepository.findById(contactInfoID);
    }

    //save
    public JContactInfo post(JContactInfo contactInfo) {

        return jContactInfoRepository.save(contactInfo);
    }

    //deleteOne
    public void delete(int employeeID) {

        jContactInfoRepository.deleteById(employeeID);
    }
}