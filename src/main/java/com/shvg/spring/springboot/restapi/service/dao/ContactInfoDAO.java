package com.shvg.spring.springboot.restapi.service.dao;

import com.shvg.spring.springboot.restapi.basedata.ContactInfoData;
import com.shvg.spring.springboot.restapi.beans.ContactInfo;
import com.shvg.spring.springboot.restapi.service.ContactInfoService;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;


@Component
public class ContactInfoDAO implements ContactInfoService {

    private int contactInfoCount = ContactInfoData.getMutableListOfContactInfos().size();

    //findAll
    public List<ContactInfo> get() {
        return ContactInfoData.getMutableListOfContactInfos();
    }

    //findOne
    public ContactInfo get(int contactInfoID) {

        for (ContactInfo contactInfo : ContactInfoData.getMutableListOfContactInfos()) {
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
        ContactInfoData.getMutableListOfContactInfos().add(contactInfo);
        return contactInfo;
    }

    //deleteOne
    public ContactInfo delete(int employeeID) {

        Iterator<ContactInfo> iterator = ContactInfoData.getMutableListOfContactInfos().iterator();

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
