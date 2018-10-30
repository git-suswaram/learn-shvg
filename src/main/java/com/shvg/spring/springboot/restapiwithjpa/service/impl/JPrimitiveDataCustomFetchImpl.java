package com.shvg.spring.springboot.restapiwithjpa.service.impl;

import com.shvg.spring.springboot.restapiwithjpa.service.JPrimitiveDataCustomFetch;
import org.springframework.stereotype.Component;

import static com.shvg.spring.basedata.data.JPrimitiveData.getIntArrayPayloads;

@Component
public class JPrimitiveDataCustomFetchImpl implements JPrimitiveDataCustomFetch {

    public Object getRequestedData(String typeOfData) {
        if (typeOfData.equalsIgnoreCase("arrayOfInts")) {
            return getIntArrayPayloads();
        } else {
            return null;
        }
    }
}
