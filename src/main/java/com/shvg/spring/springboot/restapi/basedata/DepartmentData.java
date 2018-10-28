package com.shvg.spring.springboot.restapi.baseData;

import com.shvg.spring.springboot.restapi.beans.Department;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentData {

    public static Department[] arrayOfDepartmentsPayLoad =
            {
                    new Department(101, "IT", 1001),
                    new Department(102, "Finance", 3003),
                    new Department(103, "Accounts", 5005),
            };

    public static List<Department> immutableListOfDepartments = Arrays.asList(arrayOfDepartmentsPayLoad);

    public static List<Department> mutableListOfDepartments = new ArrayList<>();
    static {
        mutableListOfDepartments.add(new Department(101, "IT", 1001));
        mutableListOfDepartments.add(new Department(102, "Finance", 3003));
        mutableListOfDepartments.add(new Department(103, "Accounts", 5005));
    }

}
