package com.shvg.java8.streams;

import com.shvg.java8.streams.model.Employee;
import com.shvg.java8.streams.model.EmployeeRepository;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMax {

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

        int maxOfElementsOfIntArray = IntStream.of(primitiveIntArrayOfNumbers).max().getAsInt();
        System.out.printf("%n maxOfElementsOfIntArray: %d%n",maxOfElementsOfIntArray);

        //******************************************************************************************************************

        int maxOfElementsOfIntArrayOrElse = IntStream.of(primitiveIntArrayOfNumbers).max().orElse(0);
        System.out.printf("%n maxOfElementsOfIntArrayOrElse: %d%n",maxOfElementsOfIntArrayOrElse);

        //******************************************************************************************************************

        int maxOfElementsOfEmptyArray = IntStream.of(emptyArray).max().orElse(0);
        System.out.printf("%n maxOfElementsOfEmptyArray: %d%n",maxOfElementsOfEmptyArray);

        //******************************************************************************************************************

        System.out.println("\nGet employee with max salary using - max()");
        System.out.println(
                listOfEmployees.stream()
                        .max(Comparator.comparing(Employee::getSalary))
                        .orElse(null));

        //******************************************************************************************************************

        Comparator<Employee> byNameLength = Comparator.comparing(Employee::getName);

        Map<Character, Optional<Employee>> longestNameByAlphabet = listOfEmployees.stream().collect(
                Collectors.groupingBy(e -> new Character(e.getName().charAt(0)),
                        Collectors.reducing(BinaryOperator.maxBy(byNameLength))));
        System.out.println("\nlongestNameByAlphabet : "+longestNameByAlphabet);

        //******************************************************************************************************************

    }
}
