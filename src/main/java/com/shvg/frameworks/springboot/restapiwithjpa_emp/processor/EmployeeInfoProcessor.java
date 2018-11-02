package com.shvg.frameworks.springboot.restapiwithjpa_emp.processor;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmploymentDetails;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeeInfo;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.request.EmployeeRequest;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.request.JEEmploymentDetailsRequest;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.service.EmployeeService;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.service.EmploymentDetailsService;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.transferobjects.EmployeeTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class EmployeeInfoProcessor {

    private JEEmployee jeEmployee;
    private JEEmploymentDetails jeEmploymentDetails;
    private EmployeeRequest employeeRequest;
    private JEEmploymentDetailsRequest jeEmploymentDetailsRequest;
    private EmployeeService employeeService;
    private EmploymentDetailsService employmentDetailsService;

    private static Logger logger = LoggerFactory.getLogger(EmployeeInfoProcessor.class);

    @Autowired
    public EmployeeInfoProcessor(JEEmployee jeEmployee, JEEmploymentDetails jeEmploymentDetails, EmployeeRequest employeeRequest, JEEmploymentDetailsRequest jeEmploymentDetailsRequest, EmployeeService employeeService, EmploymentDetailsService employmentDetailsService) {
        this.jeEmployee = jeEmployee;
        this.jeEmploymentDetails = jeEmploymentDetails;
        this.employeeRequest = employeeRequest;
        this.jeEmploymentDetailsRequest = jeEmploymentDetailsRequest;
        this.employeeService = employeeService;
        this.employmentDetailsService = employmentDetailsService;
    }

    public List<EmployeeTO> get() {
        List<JEEmployee> jeEmployees = employeeService.get();
        List<EmployeeTO> employeeTOS = new LinkedList<>();

        for (JEEmployee jeEmployee : jeEmployees) {
            EmployeeTO employeeTO = new EmployeeTO();
            employeeTO.setEmployeeId(jeEmployee.getEmployeeId());
            employeeTO.setTitle(jeEmployee.getTitle());
            employeeTO.setFirstName(jeEmployee.getFirstName());
            employeeTO.setMiddleName(jeEmployee.getMiddleName());
            employeeTO.setLastName(jeEmployee.getLastName());
            employeeTO.setDisplayName("Welcome ".concat(jeEmployee.getDisplayName()));
            employeeTOS.add(employeeTO);
        }

        return employeeTOS;
    }

    public List<JEEmployee> post(EmployeesInfo employeesInfo) {

        List<JEEmployee> jeEmployeeList = new LinkedList<>();
        List<JEEmploymentDetails> jeEmploymentDetailsList = new LinkedList<>();

        List<EmployeeInfo> employeeInfo = employeesInfo.getEmployeeInfo();

        logger.info("\nEmployeesInfo-Size: {}", employeeInfo.size());

        for (EmployeeInfo anEmployeeInfo : employeeInfo) {

            jeEmployee = employeeRequest
                    .buildRequest(anEmployeeInfo);
            jeEmployeeList.add(jeEmployee);

            jeEmploymentDetails = jeEmploymentDetailsRequest
                    .buildRequest(anEmployeeInfo.getEmployee().getEmploymentDetails());
            jeEmploymentDetailsList.add(jeEmploymentDetails);
        }

        employeeService.post(jeEmployeeList);
        employmentDetailsService.post(jeEmploymentDetailsList);

        return jeEmployeeList;

    }
}
