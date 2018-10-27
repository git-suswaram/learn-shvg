package com.shvg.spring.springboot.restapi.service;

import com.shvg.spring.springboot.restapi.beans.ContactInfo;

import java.util.List;

public interface ContactInfoService {

    List<ContactInfo> get();

    ContactInfo get(int contactInfoID);

    ContactInfo post(ContactInfo contactInfo);

    ContactInfo delete(int contactInfoID);

}
