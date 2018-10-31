package com.shvg.frameworks.springboot.restapiwithjpa.service;

import com.shvg.frameworks.springboot.restapiwithjpa.entity.JContactInfo;

import java.util.List;
import java.util.Optional;

public interface JContactInfoService {

    List<JContactInfo> get();

    Optional<JContactInfo> get(int contactInfoID);

    JContactInfo post(JContactInfo contactInfo);

    void delete(int contactInfoID);

}
