package com.shvg.spring.basedata.util;

public class Calculate {

    public static int calculateSum(int[] data){
        int sum = 0;
        for (int value:data){
            sum+=value;
        }
        return sum;
    }
}
