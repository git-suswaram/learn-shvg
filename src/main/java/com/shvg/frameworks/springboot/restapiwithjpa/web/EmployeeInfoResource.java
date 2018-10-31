package com.shvg.frameworks.springboot.restapiwithjpa.web;

import com.shvg.frameworks.springboot.restapiwithjpa.pojo.EmployeeInfo;
import com.shvg.frameworks.springboot.restapiwithjpa.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa.processor.EmployeeInfoProcessor;
import com.shvg.frameworks.springboot.restapiwithjpa.service.JEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

public class EmployeeInfoResource {

    @Autowired
    private final JEmployeeService jeEmployeeService;

    @Autowired
    private final EmployeeInfoProcessor employeeInfoProcessor;

    private static Logger logger = LoggerFactory.getLogger(EmployeeResource.class);

    public EmployeeInfoResource() {
        this.jeEmployeeService = null;
        this.employeeInfoProcessor=null;

    }

    public EmployeeInfoResource(JEmployeeService jeEmployeeService, EmployeeInfoProcessor employeeInfoProcessor) {
        this.jeEmployeeService = jeEmployeeService;
        this.employeeInfoProcessor = employeeInfoProcessor;
    }


    @PostMapping(path = "/jpa/employeeinfo")
    public void post(@Valid @RequestBody EmployeeInfo employeesInfo) {

        employeeInfoProcessor.post(employeesInfo);
    }

    @PostMapping(path = "/jpa/employeesinfo")
    public void post2(@Valid @RequestBody EmployeesInfo employeesInfo) {

        employeeInfoProcessor.post2(employeesInfo);
    }

}
