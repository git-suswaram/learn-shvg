package com.shvg.frameworks.springboot.restapiwithjpa.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalculateJunit {

    @Test
    public void calculateSum_basic(){

        Calculate calculate = new Calculate();
        int actualResult = calculate.calculateSum(new int[]{1,2,3});
        int passExpectedResult = 6;
        assertEquals(passExpectedResult,actualResult);
        //int failExpectedResult = 8;
        //assertEquals(failExpectedResult,actualResult);
    }

    @Test
    public void calculateSum_empty(){

        Calculate calculate = new Calculate();
        int actualResult = calculate.calculateSum(new int[]{});
        int passExpectedResult = 0;
        assertEquals(passExpectedResult,actualResult);
        //int failExpectedResult = 8;
        //assertEquals(failExpectedResult,actualResult);
    }

    @Test
    public void calculateSum_OneValue(){

        Calculate calculate = new Calculate();
        int actualResult = calculate.calculateSum(new int[]{1});
        int passExpectedResult = 1;
        assertEquals(passExpectedResult,actualResult);
        //int failExpectedResult = 8;
        //assertEquals(failExpectedResult,actualResult);
    }
}
