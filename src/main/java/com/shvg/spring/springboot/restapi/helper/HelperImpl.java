package com.shvg.spring.springboot.restapi.helper;

import com.shvg.spring.springboot.restapi.basedata.DepartmentData;
import com.shvg.spring.springboot.restapi.basedata.EmployeeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HelperImpl implements IHelper {

    private static Logger logger = LoggerFactory.getLogger(HelperImpl.class);
    private List<?> objectList;

    public HelperImpl(List<?> empList) {
        this.objectList = empList;
    }

    @Override
    public Object findById(Integer id)
            throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {

        for (Object object : objectList) {
            Object getId =
                    Class.forName(object.getClass().getName())
                            .getMethod("getId")
                            .invoke(object, (Object[]) null);

            if (Integer.valueOf(getId.toString()).equals(id)) {
                return object;
            }
        }
        return null;
    }


    @Override
    public List<?> findByIds(Integer[] ids) {

        return Arrays.stream(ids)
                .map((Integer e) -> {
                    try {
                        return findById(e);
                    } catch (ClassNotFoundException
                            | NoSuchMethodException
                            | IllegalAccessException
                            | InvocationTargetException e1) {
                        logger.error("Exception Occurred: {}", (Object) e1.getStackTrace());
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .peek(e -> logger.info("\nEmployeeList using findByIds: {}\n", e))
                .collect(Collectors.toList());
    }

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
