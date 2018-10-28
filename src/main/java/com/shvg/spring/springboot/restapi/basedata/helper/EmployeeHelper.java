package com.shvg.spring.springboot.restapi.basedata.helper;

import com.shvg.spring.springboot.restapi.beans.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeHelper {

    private static Logger logger = LoggerFactory.getLogger(EmployeeHelper.class);
    private List<Employee> employeesList;

    public EmployeeHelper(List<Employee> empList) {
        this.employeesList = empList;
    }

    public Employee findByID(Integer id) {

        for (Employee employee : employeesList) {
            if (employee.getEmployeeID() == id) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> findByIds(Integer[] ids) {

       return Arrays.stream(ids)
                .map((Integer e) -> findByID(e))
                .filter(Objects::nonNull)
                .peek(e->logger.info("\nEmployeeList using findByIds: {}\n",e.toString()))
                .collect(Collectors.toList());
    }

/*    public static void main(String[] args) {
        new EmployeeHelper(EmployeeData.getMutableListOfExecutives())
                .findByIds(new Integer[]{1001, 2002});
    }*/
}
