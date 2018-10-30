package com.shvg.spring.springboot.restapiwithjpa.util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestListMock {

    List mockList = mock(List.class);

    @Test
    public void test(){
        when(mockList.size()).thenReturn(5);
        assertEquals(5,mockList.size());
    }

    @Test
    public void returnDifferentValues(){
        when(mockList.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mockList.size());
        assertEquals(10,mockList.size());
    }

    @Test
    public void returnWithParameters(){
        when(mockList.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mockList.get(0));
        assertEquals(null,mockList.get(1));
    }

    @Test
    public void returnWithAnyParameters(){
        when(mockList.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in208Minutes",mockList.get(0));
        assertEquals(null,mockList.get(1));
    }

}
