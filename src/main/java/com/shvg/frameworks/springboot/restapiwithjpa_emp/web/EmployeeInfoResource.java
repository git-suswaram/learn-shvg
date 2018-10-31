package com.shvg.frameworks.springboot.restapiwithjpa_emp.web;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.processor.EmployeeInfoProcessor;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

public class EmployeeInfoResource {

    @Autowired
    private final EmployeeService employeeService;

    @Autowired
    private final EmployeeInfoProcessor employeeInfoProcessor;

    private static Logger logger = LoggerFactory.getLogger(EmployeeInfoResource.class);

    public EmployeeInfoResource() {
        this.employeeService = null;
        this.employeeInfoProcessor=null;
    }

    public EmployeeInfoResource(EmployeeService employeeService, EmployeeInfoProcessor employeeInfoProcessor) {
        this.employeeService = employeeService;
        this.employeeInfoProcessor = employeeInfoProcessor;
    }

    @PostMapping(path = "/jpa/employees-info")
    public ResponseEntity<Object> post(@Valid @RequestBody EmployeesInfo employeesInfo) {

        assert employeeInfoProcessor != null;
        employeeInfoProcessor.post(employeesInfo);
        return ResponseEntity.created(null).build();
    }

}
