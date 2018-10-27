package com.shvg.java8.streams;

import com.shvg.java8.streams.model.Employee;
import com.shvg.java8.streams.model.EmployeeRepository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilter {
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

        System.out.println("\nCount number of employees with Salary>200000 using - count()");
        System.out.println(
                listOfEmployees.stream()
                        .filter(e->e.getSalary()>200000)
                        .count()
        );

        //******************************************************************************************************************

        System.out.println("\nGet list employees that match provided employee id's and whose salary > 200000 using - filter()");
        Integer[] empIDs3 = {1,2,3};
        Stream.of(empIDs3)
                .map(employeeRepository::findById)
                .filter(e->e!=null)
                .filter(e->e.getSalary()>200000)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //******************************************************************************************************************

        System.out.println("\nGet first employee that matches provided employee id's and whose salary > 100000 using - findFirst()");
        Integer[] empIDs4 = {1,2,3};

        System.out.println(
                Stream.of(empIDs4)
                        .map(employeeRepository::findById)
                        .filter(e->e!=null)
                        .filter(e->e.getSalary()>100000)
                        .findFirst()
                        .orElse(null)
        );

        //******************************************************************************************************************

        System.out.println("\nFilter Strings starting with \"j\" and sort in descending order using - filter() and sorted(Comparator.reverseOrder())");
        listOfStrings.stream()
                .filter(e->String.valueOf(e.charAt(0)).equalsIgnoreCase("j"))
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        //******************************************************************************************************************

        System.out.println("\nFilter Strings greater than \"j\" and sort in descending order using - filter(compareToIgnoreCase) and sorted(String.CASE_INSENSITIVE_ORDER.reversed())");
        listOfStrings.stream()
                .filter(e->e.compareToIgnoreCase("j")>0)
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                .forEach(System.out::println);

        //******************************************************************************************************************

        //FixMe: Fix the issue with composite Predicate

        System.out.println("\nComposite Predicate: Filter Strings starting with \"j\" and ending with \"l\" then sort in descending order using - filter() and sorted()");

        Predicate<String> stringsStartingWithJ = e->String.valueOf(e.charAt(0)).equalsIgnoreCase("j");
        Predicate<String> stringsEndingWithL = e->String.valueOf(e.charAt(e.length()-1)).equalsIgnoreCase("l");

        listOfStrings.stream()
                .filter(stringsStartingWithJ.and(stringsEndingWithL))
                .forEach(System.out::println);

        //******************************************************************************************************************

    }
}
