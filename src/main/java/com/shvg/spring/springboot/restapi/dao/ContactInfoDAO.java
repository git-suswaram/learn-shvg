package com.shvg.spring.springboot.restapi.dao;

import com.shvg.spring.springboot.restapi.beans.ContactInfo;
import com.shvg.spring.springboot.restapi.service.ContactInfoService;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

import static com.shvg.spring.springboot.restapi.baseData.ContactInfoData.mutableListOfContactInfos;


@Component
public class ContactInfoDAO implements ContactInfoService {

    private int contactInfoCount = mutableListOfContactInfos.size();

    //findAll
    public List<ContactInfo> get() {
        return mutableListOfContactInfos;
    }

    //findOne
    public ContactInfo get(int contactInfoID) {

        for (ContactInfo contactInfo : mutableListOfContactInfos) {
            if (contactInfo.getContactInfoID() == contactInfoID) {
                return contactInfo;
            }
        }

        return null;
    }

    //save
    public ContactInfo post(ContactInfo contactInfo) {

        if (contactInfo.getContactInfoID() == 0) {
            contactInfo.setContactInfoID(++contactInfoCount);
        }
        mutableListOfContactInfos.add(contactInfo);
        return contactInfo;
    }

    //deleteOne
    public ContactInfo delete(int employeeID) {

        Iterator<ContactInfo> iterator = mutableListOfContactInfos.iterator();

        while (iterator.hasNext()) {

            ContactInfo contactInfo = iterator.next();
            if (contactInfo.getContactInfoID() == employeeID) {
                iterator.remove();
                return contactInfo;
            }
        }
        return null;
    }
}
