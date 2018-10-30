package com.shvg.spring.springboot.restapiwithjpa.util;

public class Calculate {

    public int calculateSum(int[] data){
        int sum = 0;
        for (int value:data){
            sum+=value;
        }
        return sum;
    }
}
