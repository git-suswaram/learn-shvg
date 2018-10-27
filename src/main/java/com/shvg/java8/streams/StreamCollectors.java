package com.shvg.java8.streams;

import com.shvg.java8.streams.model.Employee;
import com.shvg.java8.streams.model.EmployeeRepository;
import com.shvg.java8.streams.model.SafariEmployee;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectors {

    private static Employee[] arrayOfEmployees = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(11, "Jeff B", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(22, "Bill G", 200000.0),
            new Employee(3, "Mark Zuckerberg", 3000000.0),
            new Employee(33, "Mark Z", 3000000.0)
    };
    // get List view of the Employees
    private static List<Employee> listOfEmployees = Arrays.asList(arrayOfEmployees);

    private static EmployeeRepository employeeRepository = new EmployeeRepository(listOfEmployees);


    // initialize array of Employees
    private static SafariEmployee[] arrayOfSafariEmployees = {
            new SafariEmployee("Jason", "Red", 5000, "IT"),
            new SafariEmployee("Ashley", "Green", 7600, "IT"),
            new SafariEmployee("Matthew", "Indigo", 3587.5, "Sales"),
            new SafariEmployee("James", "Indigo", 4700.77, "Marketing"),
            new SafariEmployee("Luke", "Indigo", 6200, "IT"),
            new SafariEmployee("Jason", "Blue", 3200, "Sales"),
            new SafariEmployee("Wendy", "Brown", 4236.4, "Marketing")};
    // get List view of the Employees
    private static List<SafariEmployee> listOfSafariEmployees = Arrays.asList(arrayOfSafariEmployees);


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

        System.out.println("\nGet list of employee id's using - map()");
        Integer[] empIDs = {1,2,4};
        Stream.of(empIDs)
                .map(employeeRepository::findById)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //******************************************************************************************************************

        String commaSeparatedStringOfEmployeeNames= listOfEmployees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println("\ncommaSeparatedStringOfEmployeeNames using - collect(Collectors.joining(\", \")) : "+commaSeparatedStringOfEmployeeNames);

        //******************************************************************************************************************

        Set<String> employeeNamesAsASet= listOfEmployees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        System.out.println("\nemployeeNamesAsASet using - .collect(Collectors.toSet()): "+employeeNamesAsASet);

        //******************************************************************************************************************

        Vector<String> employeeNamesAsAVector= listOfEmployees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(Vector::new));
        System.out.println("\nemployeeNamesAsASet using - .collect(Collectors.toCollection(Vector::new)) : "+employeeNamesAsAVector);

        //******************************************************************************************************************

        DoubleSummaryStatistics doubleSummaryStatistics = listOfEmployees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("\ndoubleSummaryStatistics using - collect(Collectors.summarizingDouble(SafariEmployee::getSalary)) : "+doubleSummaryStatistics);

        //******************************************************************************************************************

        Double percentage = 10.0;
        Double totalSalaryAfter10PercentIncrement = listOfEmployees.stream()
                .collect(Collectors.reducing(
                        0.0, e1 -> e1.getSalary() * percentage / 100, (s1, s2) -> s1 + s2));
        System.out.println("\n" +
                "CalculateSalaryIncrementOfEachEmployee and return sum using " +
                "- collect(Collectors.reducing(0.0, e1 -> e1.getSalary()*percentage/100, (s1,s2)->s1+s2)): "
                +totalSalaryAfter10PercentIncrement);

        //******************************************************************************************************************

        Map<Boolean, List<Integer>> partitioningOfEvenAndOddIntegers = Arrays.asList(integerArrayOfNumbers).stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("\npartitioningOfEvenAndOddIntegers using - collect(Collectors.partitioningBy(i -> i % 2 == 0)) : "+partitioningOfEvenAndOddIntegers);

        //******************************************************************************************************************

        Map<Character, List<Employee>> groupingOfEmployeesStartingWithSameCharacter = listOfEmployees.stream()
                .collect(
                        Collectors.groupingBy(
                                e->new Character(e.getName().charAt(0))
                        )
                );
        System.out.println("\ngroupingOfEmployeeNamesStartingWithSameCharacter using - collect(Collectors.groupingBy(e->new Character(e.getName().charAt(0)))) : "
                +groupingOfEmployeesStartingWithSameCharacter);

        //******************************************************************************************************************

        Map<Character, List<Integer>> groupingOfEmployeeIdsBasedOnFirstCharacterOfName= listOfEmployees.stream()
                .collect(
                        Collectors.groupingBy(
                                e->new Character(e.getName().charAt(0)), Collectors.mapping(Employee::getId,Collectors.toList())
                        )
                );
        System.out.println("\ngroupingOfEmployeeIdsBasedOnFirstCharacterOfName using - collect(Collectors.groupingBy(e->new Character(e.getName().charAt(0)),Collectors.mapping(SafariEmployee::getId,Collectors.toList()))) : "
                +groupingOfEmployeeIdsBasedOnFirstCharacterOfName);

        //******************************************************************************************************************

        Comparator<Employee> byNameLength = Comparator.comparing(Employee::getName);

        Map<Character, Optional<Employee>> longestNameByAlphabet = listOfEmployees.stream()
                .collect(
                        Collectors.groupingBy(
                                e -> new Character(e.getName().charAt(0)), Collectors.reducing(BinaryOperator.maxBy(byNameLength))
                        )
                );
        System.out.println("\nlongestNameByAlphabet : "+longestNameByAlphabet);

        //******************************************************************************************************************

        // count number of Employees in each department
        System.out.printf("%nCount of Employees by department:%n");

        Map<String, Long> employeeCountByDepartment =
                listOfSafariEmployees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        SafariEmployee::getDepartment, TreeMap::new, Collectors.counting()
                                ));

        employeeCountByDepartment.forEach(
                (department, count) -> System.out.printf(
                        "%s has %d employee(s)%n", department, count));

        //******************************************************************************************************************



    }

}
