package com.shvg.spring.springboot.restapi.service.dao;

import com.shvg.spring.springboot.restapi.basedata.EmployeeData;
import com.shvg.spring.springboot.restapi.beans.Employee;
import com.shvg.spring.springboot.restapi.service.EmployeeService;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;


@Component
public class EmployeeDAO implements EmployeeService {

    private int employeeCount = EmployeeData.getMutableListOfExecutives().size();

    //findAll
    public List<Employee> get() {
        return EmployeeData.getMutableListOfExecutives();
    }

    //findOne
    public Employee get(int employeeID) {

        for (Employee employee : EmployeeData.getMutableListOfExecutives()) {
            if (employee.getEmployeeID() == employeeID) {
                return employee;
            }
        }

        return null;
    }

    //save
    public Employee post(Employee employee) {

        if (employee.getEmployeeID() == 0) {
            employee.setEmployeeID(++employeeCount);
        }
        EmployeeData.getMutableListOfExecutives().add(employee);
        return employee;
    }

    //deleteOne
    public Employee delete(int employeeID) {

        Iterator<Employee> iterator = EmployeeData.getMutableListOfExecutives().iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmployeeID() == employeeID) {
                iterator.remove();
                return employee;
            }
        }
        return null;
    }
}
