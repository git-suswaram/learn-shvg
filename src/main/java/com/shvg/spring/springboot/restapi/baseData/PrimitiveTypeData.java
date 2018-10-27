package com.shvg.spring.springboot.restapi.baseData;


import java.util.Arrays;
import java.util.List;

public class PrimitiveTypeData {

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



}
