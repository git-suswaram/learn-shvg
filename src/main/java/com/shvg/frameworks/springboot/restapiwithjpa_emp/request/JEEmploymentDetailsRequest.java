package com.shvg.frameworks.springboot.restapiwithjpa_emp.request;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmploymentDetails;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmploymentDetails;
import org.springframework.stereotype.Component;

@Component
public class JEEmploymentDetailsRequest {
    public JEEmploymentDetails buildRequest(EmploymentDetails employmentDetails) {

        JEEmploymentDetails jeEmployeeDetails = new JEEmploymentDetails();

        jeEmployeeDetails.setEmployeeId(employmentDetails.getEmployeeId());
        jeEmployeeDetails.setJobTitle(employmentDetails.getJobTitle());
        jeEmployeeDetails.setEmployeeType(employmentDetails.getEmployeeType());
        jeEmployeeDetails.setEmploymentStatus(employmentDetails.getEmploymentStatus());
        jeEmployeeDetails.setFirstHireDate(employmentDetails.getFirstHireDate());
        jeEmployeeDetails.setRecentHireDate(employmentDetails.getRehireDate());
        jeEmployeeDetails.setDepartmentID(employmentDetails.getDepartmentID());

        return jeEmployeeDetails;
    }
}
