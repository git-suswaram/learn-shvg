package com.shvg.spring.springboot.restapiwithjpa.basedata.jpa;

import com.shvg.spring.springboot.restapiwithjpa.entity.JDepartment;

import java.util.Arrays;
import java.util.List;

public class JDepartmentData {

    private JDepartmentData() {
        throw new IllegalStateException("Utility class");
    }

    private static JDepartment[] arrayOfJDepartmentsPayLoad =
            {
                    new JDepartment("Information Technology", 300),
                    new JDepartment("Finance", 30),
                    new JDepartment("Accounts", 33),
                    new JDepartment("Human Resources", 10),
            };

    private static List<JDepartment> immutableListOfJDepartments = Arrays.asList(arrayOfJDepartmentsPayLoad);


    public static JDepartment[] getArrayOfJDepartmentsPayLoad() {
        return arrayOfJDepartmentsPayLoad;
    }

    public static void setArrayOfJDepartmentsPayLoad(JDepartment[] arrayOfJDepartmentsPayLoad) {
        JDepartmentData.arrayOfJDepartmentsPayLoad = arrayOfJDepartmentsPayLoad;
    }

    public static List<JDepartment> getImmutableListOfJDepartments() {
        return immutableListOfJDepartments;
    }

    public static void setImmutableListOfJDepartments(List<JDepartment> immutableListOfJDepartments) {
        JDepartmentData.immutableListOfJDepartments = immutableListOfJDepartments;
    }


}
