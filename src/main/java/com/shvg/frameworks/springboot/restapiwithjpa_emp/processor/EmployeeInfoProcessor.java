package com.shvg.frameworks.springboot.restapiwithjpa_emp.processor;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.request.EmployeeRequest;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeInfoProcessor {

    @Autowired
    EmployeeRequest employeeRequest;

    @Autowired
    private EmployeeService employeeService;

    private static Logger logger = LoggerFactory.getLogger(EmployeeInfoProcessor.class);
    com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee JEEmployee = null;

    public List<com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee> post(EmployeesInfo employeesInfo) {

        List<com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee> JEEmployeeList = new ArrayList<>();

        logger.info("EmployeesInfo: {}", employeesInfo.toString());
        logger.info("EmployeesInfo-Size: {}", employeesInfo.getEmployeeInfo().size());
        logger.info("employeeRequest: {}", employeeRequest.toString());

        for (int i = 0; i < employeesInfo.getEmployeeInfo().size(); i++) {
            logger.info("=>EmployeeInfo: {}", employeesInfo.getEmployeeInfo().get(i).toString());
            JEEmployee = employeeRequest.buildRequest(employeesInfo.getEmployeeInfo().get(i));
            JEEmployeeList.add(JEEmployee);
        }

        employeeService.post(JEEmployeeList);

        return JEEmployeeList;

    }
}
