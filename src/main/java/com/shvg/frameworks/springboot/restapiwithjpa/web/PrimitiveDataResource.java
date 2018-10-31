package com.shvg.frameworks.springboot.restapiwithjpa.web;

import com.shvg.frameworks.springboot.basedata.data.JPrimitiveData;
import com.shvg.frameworks.springboot.restapiwithjpa.service.JPrimitiveDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimitiveDataResource {

    @Autowired
    private JPrimitiveDataService jPrimitiveDataService;

    private static Logger logger = LoggerFactory.getLogger(PrimitiveDataResource.class);

    @GetMapping("/jpa/getArray")
    public int[] get() {
        return JPrimitiveData.getIntArrayPayloads();
    }

    @PostMapping(path = "/jpa/getCustomData")
    public Object post(@RequestBody String typeOfData) {

        logger.info("Entered /jpa/getCustomData}");
        Object requestedData = jPrimitiveDataService.getRequestedData(typeOfData);
        logger.info("Value of requestedData: {}", requestedData);

        return requestedData;
    }

    @PostMapping(path = "/jpa/customSum")
    public int post2(@RequestBody String typeOfData) {

        logger.info("Entered /jpa/getCustomData}");
        logger.info("typeOfData: {}", typeOfData);

        int calculatedCustomSum = jPrimitiveDataService.calculateCustomSum(typeOfData);
        logger.info("Value of calculatedCustomSum: {}", calculatedCustomSum);

        return calculatedCustomSum;
    }
}
