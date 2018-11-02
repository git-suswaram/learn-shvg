package com.shvg.frameworks.springboot.restapiwithjpa_emp.request;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeeInfo;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRequest {

    public JEEmployee buildRequest(EmployeeInfo employeeInfo) {

        JEEmployee jeEmployee = new JEEmployee();
        jeEmployee.setEmployeeId(employeeInfo.getEmployee().getEmploymentDetails().getEmployeeId());
        jeEmployee.setTitle(employeeInfo.getEmployee().getTitle());
        jeEmployee.setFirstName(employeeInfo.getEmployee().getFirstName());
        jeEmployee.setLastName(employeeInfo.getEmployee().getLastName());
        jeEmployee.setMiddleName(employeeInfo.getEmployee().getMiddleName());
        jeEmployee.setDisplayName(employeeInfo.getEmployee().getDisplayName());

        return jeEmployee;
    }
}
