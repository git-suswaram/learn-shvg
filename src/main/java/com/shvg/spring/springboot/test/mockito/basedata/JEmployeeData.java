package com.shvg.spring.springboot.test.mockito.basedata;

import com.shvg.spring.springboot.test.mockito.entity.JEmployee;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JEmployeeData {

    private JEmployeeData() {
        throw new IllegalStateException("Utility class");
    }

    private static JEmployee[] arrayOfJEmployeesPayLoad =
            {
                    new JEmployee("John", "Doe", "IT"),
                    new JEmployee("Jane", "Doe", "IT"),
                    new JEmployee("Joe", "Blog", "Finance"),
                    new JEmployee("John", "Roe", "Finance"),
                    new JEmployee("Richard", "Roe", "Accounts"),
            };
    private static List<JEmployee> immutableListOfJEmployees = Arrays.asList(arrayOfJEmployeesPayLoad);

    private static List<JEmployee> mutableListOfJEmployees = new ArrayList<>();

    static {
        mutableListOfJEmployees.add(new JEmployee("John", "Doe", "IT"));
        mutableListOfJEmployees.add(new JEmployee("Jane", "Doe", "IT"));
        mutableListOfJEmployees.add(new JEmployee("Joe", "Blog", "Finance"));
        mutableListOfJEmployees.add(new JEmployee("John", "Roe", "Finance"));
        mutableListOfJEmployees.add(new JEmployee("Richard", "Roe", "Accounts"));
    }

    private static JEmployee[] arrayOfJExecutivesPayLoad =
            {
                    new JEmployee("Tommy", "Atkins", LocalDate.of(1946, Month.JANUARY, 1), "IT", "President", 12300000.00),
                    new JEmployee("Billy", "Oddie", LocalDate.of(1956, Month.FEBRUARY, 28), "IT", "EVP", 5230000.00),
                    new JEmployee("Tommy", "Oddle", LocalDate.of(1966, Month.MARCH, 03), "Finance", "SVP", 3130000.00),
                    new JEmployee("Fredy", "Costie", LocalDate.of(1986, Month.MARCH, 19), "Finance", "VP", 230000.00),
                    new JEmployee("Harry", "Cobley", LocalDate.of(1986, Month.MAY, 19), "Accounts", "SVP", 1130000.00),

            };
    private static List<JEmployee> immutableListOfJExecutives = Arrays.asList(arrayOfJExecutivesPayLoad);

    private static List<JEmployee> mutableListOfJExecutives = new ArrayList<>();

    static {
        mutableListOfJExecutives.add(new JEmployee("Tommy", "Atkins", LocalDate.of(1946, Month.JANUARY, 1), "IT", "President", 12300000.00));
        mutableListOfJExecutives.add(new JEmployee("Bill", "Oddie", LocalDate.of(1956, Month.FEBRUARY, 28), "IT", "EVP", 5230000.00));
        mutableListOfJExecutives.add(new JEmployee("Tommy", "Oddle", LocalDate.of(1966, Month.MARCH, 03), "Finance", "SVP", 3130000.00));
        mutableListOfJExecutives.add(new JEmployee("Fred", "Costie", LocalDate.of(1986, Month.MARCH, 19), "Finance", "VP", 230000.00));
        mutableListOfJExecutives.add(new JEmployee("Harry", "Cobley", LocalDate.of(1986, Month.MAY, 19), "Accounts", "SVP", 1130000.00));
    }

    public static JEmployee[] getArrayOfJEmployeesPayLoad() {
        return arrayOfJEmployeesPayLoad;
    }

    public static void setArrayOfJEmployeesPayLoad(JEmployee[] arrayOfJEmployeesPayLoad) {
        JEmployeeData.arrayOfJEmployeesPayLoad = arrayOfJEmployeesPayLoad;
    }

    public static List<JEmployee> getImmutableListOfJEmployees() {
        return immutableListOfJEmployees;
    }

    public static void setImmutableListOfJEmployees(List<JEmployee> immutableListOfJEmployees) {
        JEmployeeData.immutableListOfJEmployees = immutableListOfJEmployees;
    }

    public static List<JEmployee> getMutableListOfJEmployees() {
        return mutableListOfJEmployees;
    }

    public static void setMutableListOfJEmployees(List<JEmployee> mutableListOfJEmployees) {
        JEmployeeData.mutableListOfJEmployees = mutableListOfJEmployees;
    }

    public static JEmployee[] getArrayOfJExecutivesPayLoad() {
        return arrayOfJExecutivesPayLoad;
    }

    public static void setArrayOfJExecutivesPayLoad(JEmployee[] arrayOfJExecutivesPayLoad) {
        JEmployeeData.arrayOfJExecutivesPayLoad = arrayOfJExecutivesPayLoad;
    }

    public static List<JEmployee> getImmutableListOfJExecutives() {
        return immutableListOfJExecutives;
    }

    public static void setImmutableListOfJExecutives(List<JEmployee> immutableListOfJExecutives) {
        JEmployeeData.immutableListOfJExecutives = immutableListOfJExecutives;
    }

    public static List<JEmployee> getMutableListOfJExecutives() {
        return mutableListOfJExecutives;
    }

    public static void setMutableListOfJExecutives(List<JEmployee> mutableListOfJExecutives) {
        JEmployeeData.mutableListOfJExecutives = mutableListOfJExecutives;
    }
}
