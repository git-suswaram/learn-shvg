package com.shvg.java8.streams;

import com.shvg.java8.streams.model.Employee;
import com.shvg.java8.streams.model.EmployeeRepository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSorted {

    private static Employee[] arrayOfEmployees = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(11, "Jeff B", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(22, "Bill G", 200000.0),
            new Employee(3, "Mark Zuckerberg", 3000000.0),
            new Employee(33, "Mark Z", 3000000.0)
    };
    private static List<Employee> listOfEmployees = Arrays.asList(arrayOfEmployees);
    private static EmployeeRepository employeeRepository = new EmployeeRepository(listOfEmployees);


    private static String[] arrayOfStrings = {"foo", "bar", "joe", "jill", "moe", "jack"};
    private static List<String> listOfStrings = Arrays.asList(arrayOfStrings);

    private static int[] primitiveIntArrayOfNumbers = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7, 1, 3, 10};

    private static Integer[] integerArrayOfNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 5, 2, 8, 10};
    private static Integer[] integerArrayOfEvenNumbers = {2, 4, 6, 8, 10, 18, 12, 2, 4, 6, 2, 12, 10};
    private static Integer[] integerArrayOfOddNumbers = {1, 3, 5, 7, 9, 11, 13, 1, 3, 5, 1, 12, 9};
    private static Integer[] integerArrayOfNonMultiplesOfThreeNumbers = {1, 5, 7, 9, 11, 13};

    private static int[] emptyArray = {};
    private static int[] nullArray;

    public static void main(String[] args) {

        //******************************************************************************************************************

        System.out.println("\nGet distinct numbers from array using - distinct()");

        List<int[]> distinctIntList = Arrays.asList(primitiveIntArrayOfNumbers).stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(distinctIntList);

        //******************************************************************************************************************

        System.out.println("\nFilter Strings greater than \"j\" and sort in descending order using - filter(compareToIgnoreCase) and sorted(String.CASE_INSENSITIVE_ORDER.reversed())");
        listOfStrings.stream()
                .filter(e->e.compareToIgnoreCase("j")>0)
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                .forEach(System.out::println);

        //******************************************************************************************************************

        System.out.println("\nFilter Strings starting with \"j\" and sort in descending order using - filter() and sorted(Comparator.reverseOrder())");
        listOfStrings.stream()
                .filter(e->String.valueOf(e.charAt(0)).equalsIgnoreCase("j"))
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        //******************************************************************************************************************

        System.out.println("\nSort Employees based descending order of their name using - sorted()");
        listOfEmployees.stream()
                //.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //******************************************************************************************************************

    }
}
