package com.shvg.frameworks.springboot.restapiwithjpa.util;

import com.shvg.frameworks.springboot.basedata.util.Calculate;
import com.shvg.frameworks.springboot.restapiwithjpa.service.JPrimitiveDataCustomFetch;
import com.shvg.frameworks.springboot.restapiwithjpa.service.impl.JPrimitiveDataImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalculateStub {

    class DummyJPrimitiveDataCustomFetchStub implements JPrimitiveDataCustomFetch {

        @Override
        public Object getRequestedData(String typeOfData) {
            return new int[] {1,2,3};
        }
    }

    @Test
    public void calculateSumUsingDataService_basic() {

        JPrimitiveDataImpl jPrimitiveDataService = new JPrimitiveDataImpl();
        jPrimitiveDataService.setJPrimitiveDataCustomFetch(new DummyJPrimitiveDataCustomFetchStub());
        int actualResult = jPrimitiveDataService.calculateCustomSum("arrayOfInts");
        int passExpectedResult = 6;
        assertEquals(passExpectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {

        Calculate calculate = new Calculate();
        int actualResult = calculate.calculateSum(new int[]{});
        int passExpectedResult = 0;
        assertEquals(passExpectedResult, actualResult);
    }

    @Test
    public void calculateSum_OneValue() {

        Calculate calculate = new Calculate();
        int actualResult = calculate.calculateSum(new int[]{1});
        int passExpectedResult = 1;
        assertEquals(passExpectedResult, actualResult);
    }
}
