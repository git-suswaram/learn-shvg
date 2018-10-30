package com.shvg.spring.springboot.restapiwithjpa.util;

import com.shvg.spring.springboot.restapiwithjpa.service.JPrimitiveDataCustomFetch;
import com.shvg.spring.springboot.restapiwithjpa.service.impl.JPrimitiveDataImpl;
import com.shvg.spring.springboot.restapiwithjpa.web.PrimitiveDataResource;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestCalculateMock_Simplify1 {
    private static Logger logger = LoggerFactory.getLogger(PrimitiveDataResource.class);

    private JPrimitiveDataImpl jPrimitiveDataService = new JPrimitiveDataImpl();
    private JPrimitiveDataCustomFetch mockJPrimitiveDataCustomFetch = mock(JPrimitiveDataCustomFetch.class);

    @Before
    public void before(){
        jPrimitiveDataService.setJPrimitiveDataCustomFetch(mockJPrimitiveDataCustomFetch);
    }

    @Test
    public void calculateSumUsingMockDataService_basic() {

        when(mockJPrimitiveDataCustomFetch.getRequestedData("arrayOfInts")).thenReturn(new int[]{1,2,3});
        assertEquals(6, jPrimitiveDataService.calculateCustomSum("arrayOfInts"));
    }

    @Test
    public void calculateSumUsingMockDataService_empty() {

        when(mockJPrimitiveDataCustomFetch.getRequestedData("arrayOfInts")).thenReturn(new int[]{});
        assertEquals(0, jPrimitiveDataService.calculateCustomSum("arrayOfInts"));
    }

    @Test
    public void calculateSumUsingMockDataService_oneValue() {

        when(mockJPrimitiveDataCustomFetch.getRequestedData("arrayOfInts")).thenReturn(new int[]{13});
        assertEquals(13, jPrimitiveDataService.calculateCustomSum("arrayOfInts"));
    }
}
