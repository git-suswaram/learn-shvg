package com.shvg.frameworks.springboot.basedata.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;

import java.io.File;

public class DummyEmployeeJSONDataGenerator {

    public static EmployeesInfo generateDummyEmployeeJSON() {
        ObjectMapper mapper = new ObjectMapper();
        EmployeesInfo employeesInfo = null;

        try {

            employeesInfo =
                    mapper.readValue(new File("C:\\SRV_HVG\\IntelliJ_Workspace\\learn-shvg" +
                            "\\src\\main\\resources\\sampleRequest\\EmployeeInfo_Request.json"), EmployeesInfo.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeesInfo;
    }
}
