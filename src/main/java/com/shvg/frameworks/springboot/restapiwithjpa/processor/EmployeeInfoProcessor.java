package com.shvg.frameworks.springboot.restapiwithjpa.processor;

import com.shvg.frameworks.springboot.restapiwithjpa.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa.web.EmployeeResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmployeeInfoProcessor {
    private static Logger logger = LoggerFactory.getLogger(EmployeeResource.class);

    public void post(EmployeesInfo employeesInfo) {
        logger.info("EmployeesInfo: {}",employeesInfo.toString());
    }
}
