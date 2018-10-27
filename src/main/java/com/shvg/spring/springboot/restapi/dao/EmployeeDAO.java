package com.shvg.spring.springboot.restapi.dao;

import com.shvg.spring.springboot.restapi.beans.Employee;
import com.shvg.spring.springboot.restapi.service.EmployeeService;
import org.springframework.stereotype.Component;
import java.util.Iterator;
import java.util.List;

import static com.shvg.spring.springboot.restapi.baseData.EmployeeData.*;


@Component
public class EmployeeDAO implements EmployeeService {

    private int employeeCount = mutableListOfExecutives.size();

    //findAll
    public List<Employee> get() {
        return mutableListOfExecutives;
    }

    //findOne
    public Employee get(int employeeID) {

        for (Employee employee : mutableListOfExecutives) {
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
        mutableListOfExecutives.add(employee);
        return employee;
    }

    //deleteOne
    public Employee delete(int employeeID) {

        Iterator<Employee> iterator = mutableListOfExecutives.iterator();

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
