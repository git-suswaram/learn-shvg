package com.shvg.frameworks.springboot.basedata.data;

import com.shvg.frameworks.springboot.restapiwithjpa.entity.JDepartment;

import java.util.ArrayList;
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

    private static List<JDepartment> mutableListOfJDepartments = new ArrayList<>();

    static {
        mutableListOfJDepartments.add(new JDepartment("Information Technology", 1001));
        mutableListOfJDepartments.add(new JDepartment("Finance", 3003));
        mutableListOfJDepartments.add(new JDepartment("Accounts", 3003));
        mutableListOfJDepartments.add(new JDepartment("Human Resources", 5005));
    }

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

    public static List<JDepartment> getMutableListOfJDepartments() {
        return mutableListOfJDepartments;
    }

    public static void setMutableListOfJDepartments(List<JDepartment> mutableListOfJDepartments) {
        JDepartmentData.mutableListOfJDepartments = mutableListOfJDepartments;
    }
}
