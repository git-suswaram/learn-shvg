package com.shvg.spring.springboot.restapiwithjpa.service.impl;

import com.shvg.spring.springboot.restapiwithjpa.dao.springdatajparepository.JPrimitiveDataRepository;
import com.shvg.spring.springboot.restapiwithjpa.service.JPrimitiveDataService;
import com.shvg.spring.springboot.restapiwithjpa.util.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JPrimitiveDataImpl implements JPrimitiveDataService {

    @Autowired
    JPrimitiveDataRepository jPrimitiveDataRepository;

    @Autowired
    Calculate calculate;

    // calcuateSum
    public int calculateSum(int[] numbers){
        int sum = calculate.calculateSum(numbers);
        return sum;
    }
}
