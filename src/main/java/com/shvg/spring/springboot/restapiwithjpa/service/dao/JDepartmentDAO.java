package com.shvg.spring.springboot.restapiwithjpa.service.dao;

import com.shvg.spring.springboot.restapiwithjpa.basedata.JDepartmentData;
import com.shvg.spring.springboot.restapiwithjpa.entity.JDepartment;
import com.shvg.spring.springboot.restapiwithjpa.service.JDepartmentService;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;


@Component
public class JDepartmentDAO implements JDepartmentService {

    private int departmentCount = JDepartmentData.getImmutableListOfJDepartments().size();

    //findAll
    public List<JDepartment> get() {
        return JDepartmentData.getMutableListOfJDepartments();
    }

    //findOne
    public JDepartment get(int departmentID) {

        for (JDepartment department : JDepartmentData.getMutableListOfJDepartments()) {
            if (department.getId() == departmentID) {
                return department;
            }
        }

        return null;
    }

    //save
    public JDepartment post(JDepartment department) {

        if (department.getId() == 0) {
            department.setId(++departmentCount);
        }
        JDepartmentData.getMutableListOfJDepartments().add(department);
        return department;
    }

    //deleteOne
    public JDepartment delete(int departmentID) {

        Iterator<JDepartment> iterator = JDepartmentData.getMutableListOfJDepartments().iterator();

        while (iterator.hasNext()) {
            JDepartment department = iterator.next();
            if (department.getId() == departmentID) {
                iterator.remove();
                return department;
            }
        }
        return null;
    }
}
