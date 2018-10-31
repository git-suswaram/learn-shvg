package com.shvg.frameworks.springboot.restapiwithjpa_emp.request;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRequest {

    @Autowired
    com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee JEEmployee;

    public com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee buildRequest(EmployeeInfo employeeInfo) {
        JEEmployee.setEmployeeId(employeeInfo.getEmployee().getEmploymentDetails().getEmployeeId());
        JEEmployee.setTitle(employeeInfo.getEmployee().getTitle());
        JEEmployee.setFirstName(employeeInfo.getEmployee().getFirstName());
        JEEmployee.setLastName(employeeInfo.getEmployee().getLastName());
        JEEmployee.setMiddleName(employeeInfo.getEmployee().getMiddleName());
        JEEmployee.setDisplayName(employeeInfo.getEmployee().getDisplayName());
        JEEmployee.setJobTitle(employeeInfo.getEmployee().getEmploymentDetails().getJobTitle());
        JEEmployee.setDepartmentID(employeeInfo.getEmployee().getEmploymentDetails().getDepartmentID());

        return JEEmployee;
    }
}
