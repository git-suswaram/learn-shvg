package com.shvg.spring.springboot.restapiwithjpa.service.dao;

import com.shvg.spring.springboot.restapiwithjpa.basedata.JEmployeeData;
import com.shvg.spring.springboot.restapiwithjpa.entity.JEmployee;
import com.shvg.spring.springboot.restapiwithjpa.service.JEmployeeService;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;


@Component
public class JEmployeeDAO implements JEmployeeService {

    private int employeeCount = JEmployeeData.getMutableListOfJExecutives().size();

    //findAll
    public List<JEmployee> get() {
        return JEmployeeData.getMutableListOfJExecutives();
    }

    //findOne
    public JEmployee get(int employeeID) {

        for (JEmployee employee : JEmployeeData.getMutableListOfJExecutives()) {
            if (employee.getId() == employeeID) {
                return employee;
            }
        }

        return null;
    }

    //save
    public JEmployee post(JEmployee employee) {

        if (employee.getId() == 0) {
            employee.setId(++employeeCount);
        }
        JEmployeeData.getMutableListOfJExecutives().add(employee);
        return employee;
    }

    //deleteOne
    public JEmployee delete(int employeeID) {

        Iterator<JEmployee> iterator = JEmployeeData.getMutableListOfJExecutives().iterator();

        while (iterator.hasNext()) {
            JEmployee employee = iterator.next();
            if (employee.getId() == employeeID) {
                iterator.remove();
                return employee;
            }
        }
        return null;
    }
}
