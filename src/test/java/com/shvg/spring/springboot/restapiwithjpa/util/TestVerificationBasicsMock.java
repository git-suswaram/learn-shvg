package com.shvg.spring.springboot.restapiwithjpa.util;

import com.shvg.spring.springboot.restapiwithjpa.web.PrimitiveDataResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestVerificationBasicsMock {

    private static Logger logger = LoggerFactory.getLogger(PrimitiveDataResource.class);

    List<String> mockList = mock(List.class);

    @Test
    public void verificationBasics(){

        //System under Test
        String value1 = mockList.get(0);
        String value2 = mockList.get(1);

        //Verify that get method is called on mockList with index 0
        verify(mockList).get(0);
        //More Verifications
        verify(mockList,times(2)).get(anyInt());
        verify(mockList,atLeast(1)).get(anyInt());
        verify(mockList,atLeastOnce()).get(anyInt());
        verify(mockList,atMost(2)).get(anyInt());
        verify(mockList,never()).get(2);
    }

    @Test
    public void argumentCapture(){

        //System under Test
        mockList.add("SomeString");

        //Verification - Verify the value passed as argument to method call.
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(mockList).add(captor.capture());
        assertEquals("SomeString",captor);
    }

    @Test
    public void multipleArgumentCapture(){

        //System under Test
        mockList.add("SomeString1");
        mockList.add("SomeString2");

        //Verification - Verify the value passed as argument to method call.

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList, times(2)).add(captor.capture());

        List allValues = captor.getAllValues();

        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    public void mocking(){

        ArrayList mockArrayList = mock(ArrayList.class);

        logger.info(String.valueOf(mockArrayList.size()));//0
        logger.info(String.valueOf(mockArrayList.get(0)));//null

        mockArrayList.add("String1");
        mockArrayList.add("String2");

        logger.info(String.valueOf(mockArrayList.size()));//0
        logger.info(String.valueOf(mockArrayList.get(0)));//null

        when(mockArrayList.size()).thenReturn(5);
        logger.info(String.valueOf(mockArrayList.size()));//0
        logger.info(String.valueOf(mockArrayList.get(0)));//null
    }

    @Test
    public void spying(){

        ArrayList spyArrayList = spy(ArrayList.class);

        spyArrayList.add("String1");
        logger.info(String.valueOf(spyArrayList.size()));//0

        spyArrayList.add("String2");

        logger.info(String.valueOf(spyArrayList.size()));//0
        logger.info(String.valueOf(spyArrayList.get(0)));//null

        when(spyArrayList.size()).thenReturn(5);
        logger.info(String.valueOf(spyArrayList.size()));//0

        spyArrayList.add("String2");
        logger.info(String.valueOf(spyArrayList.size()));//0

        verify(spyArrayList).add("String1");
    }


}
