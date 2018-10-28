package com.shvg.spring.springboot.restapi.basedata;

import com.shvg.spring.springboot.restapi.beans.Employee;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeData {

    private EmployeeData() {
        throw new IllegalStateException("Utility class");
    }

    private static Employee[] arrayOfEmployeesPayLoad =
            {
                    new Employee(1101, "John", "Doe", "IT"),
                    new Employee(2102, "Jane", "Doe", "IT"),
                    new Employee(3103, "Joe", "Blog", "Finance"),
                    new Employee(4104, "John", "Roe", "Finance"),
                    new Employee(5105, "Richard", "Roe", "Accounts"),
            };
    private static List<Employee> immutableListOfEmployees = Arrays.asList(arrayOfEmployeesPayLoad);

    private static List<Employee> mutableListOfEmployees = new ArrayList<>();

    static {
        mutableListOfEmployees.add(new Employee(1101, "John", "Doe", "IT"));
        mutableListOfEmployees.add(new Employee(2102, "Jane", "Doe", "IT"));
        mutableListOfEmployees.add(new Employee(3103, "Joe", "Blog", "Finance"));
        mutableListOfEmployees.add(new Employee(4104, "John", "Roe", "Finance"));
        mutableListOfEmployees.add(new Employee(5105, "Richard", "Roe", "Accounts"));

    }

    private static Employee[] arrayOfExecutivesPayLoad =
            {
                    new Employee(1001, "Tommy", "Atkins", LocalDate.of(1946, Month.JANUARY, 1), "IT", "President", 12300000.00),
                    new Employee(2002, "Bill", "Oddie", LocalDate.of(1956, Month.FEBRUARY, 28), "IT", "EVP", 5230000.00),
                    new Employee(3003, "Tommy", "Oddle", LocalDate.of(1966, Month.MARCH, 03), "Finance", "SVP", 3130000.00),
                    new Employee(4004, "Fred", "Costie", LocalDate.of(1986, Month.MARCH, 19), "Finance", "VP", 230000.00),
                    new Employee(5005, "Harry", "Cobley", LocalDate.of(1986, Month.MAY, 19), "Accounts", "SVP", 1130000.00),

            };
    private static List<Employee> immutableListOfExecutives = Arrays.asList(arrayOfExecutivesPayLoad);

    private static List<Employee> mutableListOfExecutives = new ArrayList<>();

    static {
        mutableListOfExecutives.add(new Employee(1001, "Tommy", "Atkins", LocalDate.of(1946, Month.JANUARY, 1), "IT", "President", 12300000.00));
        mutableListOfExecutives.add(new Employee(2002, "Bill", "Oddie", LocalDate.of(1956, Month.FEBRUARY, 28), "IT", "EVP", 5230000.00));
        mutableListOfExecutives.add(new Employee(3003, "Tommy", "Oddle", LocalDate.of(1966, Month.MARCH, 03), "Finance", "SVP", 3130000.00));
        mutableListOfExecutives.add(new Employee(4004, "Fred", "Costie", LocalDate.of(1986, Month.MARCH, 19), "Finance", "VP", 230000.00));
        mutableListOfExecutives.add(new Employee(5005, "Harry", "Cobley", LocalDate.of(1986, Month.MAY, 19), "Accounts", "SVP", 1130000.00));
    }

    public static Employee[] getArrayOfEmployeesPayLoad() {
        return arrayOfEmployeesPayLoad;
    }

    public static List<Employee> getImmutableListOfEmployees() {
        return immutableListOfEmployees;
    }

    public static List<Employee> getMutableListOfEmployees() {
        return mutableListOfEmployees;
    }

    public static Employee[] getArrayOfExecutivesPayLoad() {
        return arrayOfExecutivesPayLoad;
    }

    public static List<Employee> getImmutableListOfExecutives() {
        return immutableListOfExecutives;
    }

    public static List<Employee> getMutableListOfExecutives() {
        return mutableListOfExecutives;
    }
}
