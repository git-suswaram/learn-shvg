package com.shvg.frameworks.springboot.restapiwithjpa_emp.processor;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmploymentDetails;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.request.EmployeeRequest;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.request.JEEmploymentDetailsRequest;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.service.EmployeeService;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.service.EmploymentDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class EmployeeInfoProcessor {

    @Autowired
    private JEEmployee jeEmployee;

    @Autowired
    private JEEmploymentDetails jeEmploymentDetails;

    @Autowired
    private EmployeeRequest employeeRequest;

    @Autowired
    private JEEmploymentDetailsRequest jeEmploymentDetailsRequest;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmploymentDetailsService employmentDetailsService;

    private static Logger logger = LoggerFactory.getLogger(EmployeeInfoProcessor.class);

    public List<JEEmployee> post(EmployeesInfo employeesInfo) {

        List<JEEmployee> jeEmployeeList = new LinkedList<>();
        List<JEEmploymentDetails> jeEmploymentDetailsList = new LinkedList<>();

        logger.info("\nEmployeesInfo-Size: {}", employeesInfo.getEmployeeInfo().size());

        for (int i = 0; i < employeesInfo.getEmployeeInfo().size(); i++) {

            jeEmployee = employeeRequest
                    .buildRequest(employeesInfo.getEmployeeInfo().get(i));
            jeEmployeeList.add(jeEmployee);

            jeEmploymentDetails = jeEmploymentDetailsRequest
                    .buildRequest(employeesInfo.getEmployeeInfo().get(i).getEmployee().getEmploymentDetails());
            jeEmploymentDetailsList.add(jeEmploymentDetails);
        }

        employeeService.post(jeEmployeeList);
        employmentDetailsService.post(jeEmploymentDetailsList);

        return jeEmployeeList;

    }
}
