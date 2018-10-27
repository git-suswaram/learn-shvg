package com.shvg.java8.streams;

import com.shvg.java8.streams.model.Employee;
import com.shvg.java8.streams.model.EmployeeRepository;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class StreamSummaryStatistics {

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

        IntSummaryStatistics summaryStatisticsOfElementsOfIntArray = IntStream.of(primitiveIntArrayOfNumbers).summaryStatistics();
        System.out.printf("%n summaryStatisticsOfElementsOfIntArray - count: %d%n",
                summaryStatisticsOfElementsOfIntArray.getCount());
        System.out.printf("%n summaryStatisticsOfElementsOfIntArray - max: %d%n",
                summaryStatisticsOfElementsOfIntArray.getMax());
        System.out.printf("%n summaryStatisticsOfElementsOfIntArray - min: %d%n",
                summaryStatisticsOfElementsOfIntArray.getMin());
        System.out.printf("%n summaryStatisticsOfElementsOfIntArray - sum: %d%n",
                summaryStatisticsOfElementsOfIntArray.getSum());
        System.out.printf("%n summaryStatisticsOfElementsOfIntArray - average: %.2f%n",
                summaryStatisticsOfElementsOfIntArray.getAverage());
        System.out.println("\n#################################################################");

        //******************************************************************************************************************

        IntSummaryStatistics summaryStatisticsOfElementsOfEmptyArray = IntStream.of(emptyArray).summaryStatistics();
        System.out.printf("%n summaryStatisticsOfElementsOfEmptyArray - count: %d%n",
                summaryStatisticsOfElementsOfEmptyArray.getCount());
        System.out.printf("%n summaryStatisticsOfElementsOfEmptyArray - max: %d%n",
                summaryStatisticsOfElementsOfEmptyArray.getMax());
        System.out.printf("%n summaryStatisticsOfElementsOfEmptyArray - min: %d%n",
                summaryStatisticsOfElementsOfEmptyArray.getMin());
        System.out.printf("%n summaryStatisticsOfElementsOfEmptyArray - sum: %d%n",
                summaryStatisticsOfElementsOfEmptyArray.getSum());
        System.out.printf("%n summaryStatisticsOfElementsOfEmptyArray - average: %.2f%n",
                summaryStatisticsOfElementsOfEmptyArray.getAverage());

        //******************************************************************************************************************

        DoubleSummaryStatistics doubleSummaryStatistics2 = listOfEmployees.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
        System.out.println("\ndoubleSummaryStatistics2 using - mapToDouble(SafariEmployee::getSalary).summaryStatistics() : "
                +doubleSummaryStatistics2);

        //******************************************************************************************************************

    }
}
