package com.shvg.spring.springboot.restapiwithjpa.basedata;


import java.util.Arrays;
import java.util.List;

public class JPrimitiveData {

    private JPrimitiveData() {
        throw new IllegalStateException("Utility class");
    }

    private static int[] intArrayPayloads =
            {
                    1, 2, 3, 4, 5
            };
    private static List<int[]> listOfInts = Arrays.asList(intArrayPayloads);


    private static Integer[] integerArrayPayloads =
            {
                    1, 2, 3, 4, 5
            };
    private static List<Integer> listOfIntegers = Arrays.asList(integerArrayPayloads);


    private static String[] stringArrayPayloads =
            {
                    "John Doe", "Jane Doe", "Joe Blogs", "John Roe", "Richard Roe"
            };
    private static List<String> listOfStrings = Arrays.asList(stringArrayPayloads);

    public static int[] getIntArrayPayloads() {
        return intArrayPayloads;
    }

    public static List<int[]> getListOfInts() {
        return listOfInts;
    }

    public static Integer[] getIntegerArrayPayloads() {
        return integerArrayPayloads;
    }

    public static List<Integer> getListOfIntegers() {
        return listOfIntegers;
    }

    public static String[] getStringArrayPayloads() {
        return stringArrayPayloads;
    }

    public static List<String> getListOfStrings() {
        return listOfStrings;
    }
}
