package com.shvg.frameworks.springboot.restapiwithjpa.util;

import com.shvg.frameworks.springboot.restapiwithjpa.service.JPrimitiveDataCustomFetch;
import com.shvg.frameworks.springboot.restapiwithjpa.service.impl.JPrimitiveDataImpl;
import com.shvg.frameworks.springboot.restapiwithjpa.web.PrimitiveDataResource;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestCalculateMock {
    private static Logger logger = LoggerFactory.getLogger(PrimitiveDataResource.class);

    @Test
    public void calculateSumUsingMockDataService_basic() {

        JPrimitiveDataImpl jPrimitiveDataService = new JPrimitiveDataImpl();

        JPrimitiveDataCustomFetch mockJPrimitiveDataCustomFetch = mock(JPrimitiveDataCustomFetch.class);
        when(mockJPrimitiveDataCustomFetch.getRequestedData("arrayOfInts")).thenReturn(new int[]{1,2,3});
        jPrimitiveDataService.setJPrimitiveDataCustomFetch(mockJPrimitiveDataCustomFetch);

        int passExpectedResult = 6;
        int actualResult = jPrimitiveDataService.calculateCustomSum("arrayOfInts");
        logger.info("actual Result from : {}", actualResult);

        assertEquals(passExpectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingMockDataService_empty() {

        JPrimitiveDataImpl jPrimitiveDataService = new JPrimitiveDataImpl();

        JPrimitiveDataCustomFetch mockJPrimitiveDataCustomFetch = mock(JPrimitiveDataCustomFetch.class);
        when(mockJPrimitiveDataCustomFetch.getRequestedData("arrayOfInts")).thenReturn(new int[]{});
        jPrimitiveDataService.setJPrimitiveDataCustomFetch(mockJPrimitiveDataCustomFetch);

        int passExpectedResult = 0;
        int actualResult = jPrimitiveDataService.calculateCustomSum("arrayOfInts");
        logger.info("actual Result from : {}", actualResult);

        assertEquals(passExpectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingMockDataService_oneValue() {

        JPrimitiveDataImpl jPrimitiveDataService = new JPrimitiveDataImpl();

        JPrimitiveDataCustomFetch mockJPrimitiveDataCustomFetch = mock(JPrimitiveDataCustomFetch.class);
        when(mockJPrimitiveDataCustomFetch.getRequestedData("arrayOfInts")).thenReturn(new int[]{13});
        jPrimitiveDataService.setJPrimitiveDataCustomFetch(mockJPrimitiveDataCustomFetch);

        int passExpectedResult = 13;
        int actualResult = jPrimitiveDataService.calculateCustomSum("arrayOfInts");
        logger.info("actual Result from : {}", actualResult);

        assertEquals(passExpectedResult, actualResult);
    }
}
