package com.shvg.java8.streams;

import com.shvg.java8.streams.model.Employee;
import com.shvg.java8.streams.model.EmployeeRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamCount {

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

        long countOfElementsOfIntArray = IntStream.of(primitiveIntArrayOfNumbers)
                                            .count();
        System.out.printf("%n countOfElementsOfIntArray: %d%n",countOfElementsOfIntArray);

        //******************************************************************************************************************

        long countOfElementsOfEmptyArray = IntStream.of(emptyArray).count();
        System.out.printf("%n countOfElementsOfEmptyArray: %d%n",countOfElementsOfEmptyArray);

        //******************************************************************************************************************

        //TODO: Is it possible to check if the value passed to Instream is not null inside Instream.Of()
        //long countOfElementsOfnullArray = IntStream.of(nullArray).count();
        //System.out.printf("%n countOfElementsOfnullArray: %d%n",countOfElementsOfnullArray);

        //******************************************************************************************************************
        System.out.println("\nCount number of employees with Salary>200000 using - count()");
        System.out.println(
                listOfEmployees.stream()
                        .filter(e->e.getSalary()>200000)
                        .count()
        );

        //******************************************************************************************************************

    }
}
