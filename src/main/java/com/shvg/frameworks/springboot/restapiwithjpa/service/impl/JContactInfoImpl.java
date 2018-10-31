package com.shvg.frameworks.springboot.restapiwithjpa.service.impl;

import com.shvg.frameworks.springboot.restapiwithjpa.entity.JContactInfo;
import com.shvg.frameworks.springboot.restapiwithjpa.repository.JContactInfoRepository;
import com.shvg.frameworks.springboot.restapiwithjpa.service.JContactInfoService;
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