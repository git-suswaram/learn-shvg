package com.shvg.spring.springboot.restapiwithjpa.util;

import com.shvg.spring.springboot.restapiwithjpa.service.JPrimitiveDataCustomFetch;
import com.shvg.spring.springboot.restapiwithjpa.service.impl.JPrimitiveDataImpl;
import com.shvg.spring.springboot.restapiwithjpa.web.PrimitiveDataResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestCalculateMock_Simplify2 {

    private static Logger logger = LoggerFactory.getLogger(PrimitiveDataResource.class);

    @InjectMocks
    JPrimitiveDataImpl jPrimitiveDataService;

    @Mock
    JPrimitiveDataCustomFetch mockJPrimitiveDataCustomFetch;


    /**
     * When using @InjectMocks and @Mock, mockito automatically takes care of setting the mocks.
     */

    /*
    @Before
    public void before(){
        jPrimitiveDataService.setJPrimitiveDataCustomFetch(mockJPrimitiveDataCustomFetch);
    }
    */

    @Test
    public void calculateSumUsingMockDataService_basic() {

        when(mockJPrimitiveDataCustomFetch.getRequestedData("arrayOfInts")).thenReturn(new int[]{1, 2, 3});
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
