package com.shvg.spring.springboot.test.mockito.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalculate {

    @Test
    public void calculateSum_basic(){

        Calculate calculate = new Calculate();
        int actualResult = calculate.calculateSum(new int[]{1,2,3});
        int passExpectedResult = 6;
        int failExpectedResult = 8;
        assertEquals(passExpectedResult,actualResult);
        //assertEquals(failExpectedResult,actualResult);

    }
}
