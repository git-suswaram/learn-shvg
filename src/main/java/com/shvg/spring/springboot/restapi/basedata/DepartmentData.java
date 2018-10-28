package com.shvg.spring.springboot.restapi.basedata;

import com.shvg.spring.springboot.restapi.beans.Department;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentData {

    private DepartmentData() {
        throw new IllegalStateException("Utility class");
    }

    private static Department[] arrayOfDepartmentsPayLoad =
            {
                    new Department(101, "Information Technology", 1001),
                    new Department(102, "Finance", 3003),
                    new Department(103, "Accounts", 3003),
                    new Department(104, "Human Resources", 5005),
            };

    private static List<Department> immutableListOfDepartments = Arrays.asList(arrayOfDepartmentsPayLoad);

    private static List<Department> mutableListOfDepartments = new ArrayList<>();

    static {
        mutableListOfDepartments.add(new Department(101, "Information Technology", 1001));
        mutableListOfDepartments.add(new Department(102, "Finance", 3003));
        mutableListOfDepartments.add(new Department(103, "Accounts", 3003));
        mutableListOfDepartments.add(new Department(104, "Accounts", 5005));
    }

    public static List<Department> getImmutableListOfDepartments() {
        return immutableListOfDepartments;
    }

    public static List<Department> getMutableListOfDepartments() {
        return mutableListOfDepartments;
    }

    public static Department[] getArrayOfDepartmentsPayLoad() {
        return arrayOfDepartmentsPayLoad;
    }
}
