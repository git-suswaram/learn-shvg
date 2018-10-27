package com.shvg.spring.springboot.springintegration.annotation.processEndpoints.serviceActivator.data;


import java.util.Arrays;
import java.util.List;

public class Data {

    public static int[] intArrayPayloads =
            {
                    1, 2, 3, 4, 5
            };
    public static List<int[]> listOfints = Arrays.asList(intArrayPayloads);


    public static Integer[] integerArrayPayloads =
            {
                    1, 2, 3, 4, 5
            };
    public static List<Integer> listOfintegers = Arrays.asList(integerArrayPayloads);


    public static String[] stringArrayPayloads =
            {
                    "John Doe", "Jane Doe", "Joe Bloggs", "John Roe", "Richard Roe"
            };
    public static List<String> listOfStrings = Arrays.asList(stringArrayPayloads);


    public static Person[] arrayOfPersonsPayLoad =
            {
                    new Person(1, "John", "Doe"),
                    new Person(2, "Jane", "Doe"),
                    new Person(3, "Joe", "Blog"),
                    new Person(4, "John", "Roe"),
                    new Person(5, "Richard", "Roe"),
            };
    public static List<Person> listOfPersons = Arrays.asList(arrayOfPersonsPayLoad);

}
