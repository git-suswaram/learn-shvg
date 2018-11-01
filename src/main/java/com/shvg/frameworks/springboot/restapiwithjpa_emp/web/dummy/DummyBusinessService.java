package com.shvg.frameworks.springboot.restapiwithjpa_emp.web.dummy;

import com.shvg.frameworks.springboot.basedata.data.DummyEmployeeJSONDataGenerator;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import org.springframework.stereotype.Component;

@Component
public class DummyBusinessService {

    public EmployeesInfo retrieveHardCodedJson() {
        return DummyEmployeeJSONDataGenerator.generateDummyEmployeeJSON();
    }
}
