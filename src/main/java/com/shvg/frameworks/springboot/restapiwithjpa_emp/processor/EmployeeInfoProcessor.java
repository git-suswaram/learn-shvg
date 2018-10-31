package com.shvg.frameworks.springboot.restapiwithjpa_emp.processor;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.request.EmployeeRequest;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class EmployeeInfoProcessor {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    JEEmployee jeEmployee;
    @Autowired
    private EmployeeRequest employeeRequest;

    private static Logger logger = LoggerFactory.getLogger(EmployeeInfoProcessor.class);

    public List<JEEmployee> post(EmployeesInfo employeesInfo) {

        List<JEEmployee> jeEmployeeList = new LinkedList<>();

        logger.info("\nEmployeesInfo-Size: {}", employeesInfo.getEmployeeInfo().size());

        for (int i = 0; i < employeesInfo.getEmployeeInfo().size(); i++) {
            jeEmployee = employeeRequest.buildRequest(employeesInfo.getEmployeeInfo().get(i));
            jeEmployeeList.add(jeEmployee);
        }

        employeeService.post(jeEmployeeList);

        return jeEmployeeList;

    }
}
