package com.shvg.spring.springboot.test.mockito.web;

import com.shvg.spring.springboot.test.mockito.basedata.PrimitiveTypeData;
import com.shvg.spring.springboot.test.mockito.service.JPrimitiveDataService;
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
    private final JPrimitiveDataService jPrimitiveDataService;

    private static Logger logger = LoggerFactory.getLogger(PrimitiveDataResource.class);

    public PrimitiveDataResource() {
        jPrimitiveDataService = null;
    }

    public PrimitiveDataResource(JPrimitiveDataService jPrimitiveDataService) {
        this.jPrimitiveDataService = jPrimitiveDataService;
    }

    @GetMapping("/jpa/getArray")
    public int[] get(){
        return PrimitiveTypeData.getIntArrayPayloads();
    }

    @PostMapping(path = "/jpa/sum")
    public int post(@RequestBody int[] numbers) {

        logger.info("Entered /jpa/sum}");
        int calculateSum = jPrimitiveDataService.calculateSum(numbers);
        logger.info("Value of calculateSum: {}",calculateSum);

        return calculateSum;
    }
}
