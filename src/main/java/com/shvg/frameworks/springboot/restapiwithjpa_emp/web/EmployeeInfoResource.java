package com.shvg.frameworks.springboot.restapiwithjpa_emp.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.processor.EmployeeInfoProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.File;

@RestController
public class EmployeeInfoResource {

    @Autowired
    private EmployeeInfoProcessor employeeInfoProcessor;

    private static Logger logger = LoggerFactory.getLogger(EmployeeInfoResource.class);


    @GetMapping(path = "/jpa/employees-info")
    public EmployeesInfo get() {

        ObjectMapper mapper = new ObjectMapper();
        EmployeesInfo employeesInfo = null;

        try {

            employeesInfo = mapper
                    .readValue(new File("C:\\SRV_HVG\\IntelliJ_Workspace\\learn-shvg" +
                            "\\src\\test\\java\\com\\shvg\\frameworks\\springboot\\restapiwithjpa_emp" +
                            "\\web\\EmployeeInfo_Request.json"), EmployeesInfo.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeesInfo;
    }

    @PostMapping(path = "/jpa/employees-info")
    public ResponseEntity<Object> post(@Valid @RequestBody EmployeesInfo employeesInfo) {

        assert employeeInfoProcessor != null;
        employeeInfoProcessor.post(employeesInfo);
        return ResponseEntity.created(null).build();
    }

}
