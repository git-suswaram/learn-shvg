package com.shvg.java8.streams;

import com.shvg.java8.streams.model.Employee;
import com.shvg.java8.streams.model.EmployeeRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMisc {
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

        List<Integer> intEvenList = Arrays.asList(integerArrayOfEvenNumbers);
        Boolean allEven = intEvenList.stream().allMatch(i->i%2==0);
        System.out.println("\nValue of .allMatch(i->i%2==0) on intEvenList is - "+allEven);

        //******************************************************************************************************************

        List<Integer> intOddList = Arrays.asList(integerArrayOfOddNumbers);
        Boolean allOdd= intOddList.stream().anyMatch(i->i%2==0);
        System.out.println("\nValue of .anyMatch(i->i%2==0) on intOddList is - "+allOdd);

        //******************************************************************************************************************

        List<Integer> intNoneMultiplesOfThree = Arrays.asList(integerArrayOfNonMultiplesOfThreeNumbers);
        Boolean noneMultiplesOfThree= intNoneMultiplesOfThree.stream().noneMatch(i->i%3==0);
        System.out.println("\nValue of .noneMatch(i->i%3==0) on intEvenList is - "+noneMultiplesOfThree);

        //******************************************************************************************************************

        System.out.println("\n//Short-Circuiting operations - skip & limit");
        Stream<Integer> infiniteIntegerStream = Stream.iterate(4, i->i*2);
        infiniteIntegerStream
                            .skip(0)
                            .limit(9)
                            .collect(Collectors.toList())
                            .forEach(System.out::println);

        //******************************************************************************************************************

        System.out.println("\nGet distinct numbers from array using - distinct()");
        List<int[]> distinctIntList = Arrays.asList(primitiveIntArrayOfNumbers).stream()
                                            .distinct()
                                            .sorted()
                                            .collect(Collectors.toList());
        System.out.println(distinctIntList);

        //******************************************************************************************************************


    }
}
