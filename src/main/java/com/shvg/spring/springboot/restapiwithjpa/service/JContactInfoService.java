package com.shvg.spring.springboot.restapiwithjpa.service;

import com.shvg.spring.springboot.restapiwithjpa.entity.JContactInfo;

import java.util.List;

public interface JContactInfoService {

    List<JContactInfo> get();

    JContactInfo get(int contactInfoID);

    JContactInfo post(JContactInfo contactInfo);

    JContactInfo delete(int contactInfoID);

}
