package com.shvg.spring.springboot.restapiwithjpa.service.dao;

import com.shvg.spring.springboot.restapiwithjpa.basedata.JContactInfoData;
import com.shvg.spring.springboot.restapiwithjpa.entity.JContactInfo;
import com.shvg.spring.springboot.restapiwithjpa.service.JContactInfoService;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;


@Component
public class JContactInfoDAO implements JContactInfoService {

    private int contactInfoCount = JContactInfoData.getMutableListOfContactInfos().size();

    //findAll
    public List<JContactInfo> get() {
        return JContactInfoData.getMutableListOfContactInfos();
    }

    //findOne
    public JContactInfo get(int contactInfoID) {

        for (JContactInfo contactInfo : JContactInfoData.getMutableListOfContactInfos()) {
            if (contactInfo.getId() == contactInfoID) {
                return contactInfo;
            }
        }

        return null;
    }

    //save
    public JContactInfo post(JContactInfo contactInfo) {

        if (contactInfo.getId() == 0) {
            contactInfo.setId(++contactInfoCount);
        }
        JContactInfoData.getMutableListOfContactInfos().add(contactInfo);
        return contactInfo;
    }

    //deleteOne
    public JContactInfo delete(int employeeID) {

        Iterator<JContactInfo> iterator = JContactInfoData.getMutableListOfContactInfos().iterator();

        while (iterator.hasNext()) {

            JContactInfo contactInfo = iterator.next();
            if (contactInfo.getId() == employeeID) {
                iterator.remove();
                return contactInfo;
            }
        }
        return null;
    }
}
