package com.shvg.spring.springboot.restapiwithjpa;

import com.shvg.spring.springboot.restapiwithjpa.basedata.DepartmentData;
import com.shvg.spring.springboot.restapiwithjpa.basedata.EmployeeData;
import com.shvg.spring.springboot.restapiwithjpa.helper.HelperImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class testMain {
    private static Logger logger = LoggerFactory.getLogger(HelperImpl.class);

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {

        Object employeeById = new HelperImpl(EmployeeData.getMutableListOfExecutives())
                .findById(2002);
        logger.info("\nOutput from Employee::findById: {}\n", employeeById);

        Object departmentById = new HelperImpl(DepartmentData.getMutableListOfDepartments())
                .findById(103);
        logger.info("\nOutput from Department::findById: {}\n", departmentById);

        List<?> employeeByIds = new HelperImpl(EmployeeData.getMutableListOfExecutives())
                .findByIds(new Integer[]{1001, 2002});
        logger.info("\nOutput from Employee::findByIds: {}\n", employeeByIds);

        Object departmentByIds = new HelperImpl(DepartmentData.getMutableListOfDepartments())
                .findByIds(new Integer[]{103, 104});
        logger.info("\nOutput from Department::findByIds: {}\n", departmentByIds);

    }
}
