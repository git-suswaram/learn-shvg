package com.shvg.frameworks.springboot.restapiwithjpa_emp.web.dummy;

import com.shvg.frameworks.springboot.basedata.data.DummyEmployeeJSONDataGenerator;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyEmployeeInfoResource {

    @Autowired
    private DummyBusinessService dummyBusinessService;

    private static Logger logger = LoggerFactory.getLogger(DummyEmployeeInfoResource.class);

    @GetMapping(path = "/jpa/hardcoded-employees-info-json")
    public EmployeesInfo getJsonHardCoded() {

        return DummyEmployeeJSONDataGenerator.generateDummyEmployeeJSON();
    }

    @GetMapping(path = "/jpa/employees-info-business")
    public EmployeesInfo getJsonFromBusinessService() {

        return dummyBusinessService.retrieveHardCodedJson();

    }

}
