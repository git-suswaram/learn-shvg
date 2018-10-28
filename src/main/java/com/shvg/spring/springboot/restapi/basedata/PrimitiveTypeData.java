package com.shvg.spring.springboot.restapi.basedata;


import java.util.Arrays;
import java.util.List;

public class PrimitiveTypeData {

    private PrimitiveTypeData() {
        throw new IllegalStateException("Utility class");
    }

    private static final int[] intArrayPayloads =
            {
                    1, 2, 3, 4, 5
            };
    private static final List<int[]> listOfints = Arrays.asList(intArrayPayloads);


    private static final Integer[] integerArrayPayloads =
            {
                    1, 2, 3, 4, 5
            };
    private static final List<Integer> listOfintegers = Arrays.asList(integerArrayPayloads);


    private static final String[] stringArrayPayloads =
            {
                    "John Doe", "Jane Doe", "Joe Bloggs", "John Roe", "Richard Roe"
            };
    private static final List<String> listOfStrings = Arrays.asList(stringArrayPayloads);

    public static int[] getIntArrayPayloads() {
        return intArrayPayloads;
    }

    public static List<int[]> getListOfints() {
        return listOfints;
    }

    public static Integer[] getIntegerArrayPayloads() {
        return integerArrayPayloads;
    }

    public static List<Integer> getListOfintegers() {
        return listOfintegers;
    }

    public static String[] getStringArrayPayloads() {
        return stringArrayPayloads;
    }

    public static List<String> getListOfStrings() {
        return listOfStrings;
    }
}
