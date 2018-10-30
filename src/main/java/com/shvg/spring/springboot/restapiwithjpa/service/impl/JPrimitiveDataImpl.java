package com.shvg.spring.springboot.restapiwithjpa.service.impl;

import com.shvg.spring.springboot.restapiwithjpa.dao.springdatajparepository.JPrimitiveDataRepository;
import com.shvg.spring.springboot.restapiwithjpa.service.JPrimitiveDataCustomFetch;
import com.shvg.spring.springboot.restapiwithjpa.service.JPrimitiveDataService;
import com.shvg.spring.springboot.restapiwithjpa.util.Calculate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JPrimitiveDataImpl implements JPrimitiveDataService {

    @Autowired
    JPrimitiveDataRepository jPrimitiveDataRepository;

    @Autowired
    JPrimitiveDataCustomFetch jPrimitiveDataCustomFetch;

    private static Logger logger = LoggerFactory.getLogger(JPrimitiveDataImpl.class);

    public void setJPrimitiveDataCustomFetch(JPrimitiveDataCustomFetch jPrimitiveDataCustomFetch) {
        this.jPrimitiveDataCustomFetch = jPrimitiveDataCustomFetch;
    }

    //CalculateSum
    public int calculateSum(int[] numbers) {
        return Calculate.calculateSum(numbers);
    }

    @Override
    public Object getRequestedData(String typeOfData) {
        return jPrimitiveDataCustomFetch.getRequestedData(typeOfData);
    }

    @Override
    public int calculateCustomSum(String typeOfData) {

        Object requestedData = getRequestedData(typeOfData);
        logger.info("Class of returned data: {}", requestedData.getClass().getName());

        if (requestedData.getClass().getName().equalsIgnoreCase("[I")) {
            logger.info("int Array");
            return calculateSum((int[]) requestedData);
        } else {
            return 0;
        }
    }
}
