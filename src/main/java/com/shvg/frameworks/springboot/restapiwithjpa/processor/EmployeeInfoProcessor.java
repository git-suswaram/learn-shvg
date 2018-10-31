package com.shvg.frameworks.springboot.restapiwithjpa.processor;

import com.shvg.frameworks.springboot.restapiwithjpa.pojo.EmployeeInfo;
import com.shvg.frameworks.springboot.restapiwithjpa.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa.web.EmployeeResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmployeeInfoProcessor {
    private static Logger logger = LoggerFactory.getLogger(EmployeeResource.class);

    public void post(EmployeeInfo employeeInfo) {
        logger.info("employee info: {}",employeeInfo.toString());
    }

    public void post2(EmployeesInfo employeesInfo) {
        logger.info("MultipleEmployeesInfo: {}",employeesInfo.toString());
    }
}
