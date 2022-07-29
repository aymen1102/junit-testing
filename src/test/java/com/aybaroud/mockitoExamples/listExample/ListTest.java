package com.aybaroud.mockitoExamples.listExample;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

class ListTest {

    @Test
    void letsMockListSizeMethod() {
        /* Mock List class */
        List mockList = Mockito.mock(List.class);
        /* when then */
        Mockito.when(mockList.size())
                .thenReturn(2);
        /* begin test */
        int expected = 2;
        int actual = mockList.size();
        assertEquals(expected, actual);
    }

    @Test
    void letsMockListSizeMethod_ReturnMultipleValue() {
        /* Mock List class */
        List mockList = Mockito.mock(List.class);
        /* when then */
        Mockito.when(mockList.size())
                .thenReturn(2)
                .thenReturn(3)
                .thenReturn(4);
        /* begin test */
        int actual = mockList.size();
        assertEquals(2, actual);
        assertEquals(3, actual);
        assertEquals(4, actual);
    }

    @Test
    void letsMockListGet() {
        /* Mock List class */
        List mockList = Mockito.mock(List.class);
        /* when then */
        Mockito.when(mockList.get(0))
                .thenReturn("Aymen");
        /* begin test */
        String expected = "Aymen";
        String actual = (String) mockList.get(0);
        assertEquals(expected, actual);
        assertNull(mockList.get(1));
    }

    @Test
    void letsMockListGet_UsingArgumentMatcher() {
        /* Mock List class */
        List mockList = Mockito.mock(List.class);
        /* when then */
        Mockito.when(mockList.get(anyInt()))
                .thenReturn("Aymen");
        /* begin test */
        String expected = "Aymen";
        assertEquals(expected, mockList.get(23));
        assertEquals(expected, mockList.get(59));
    }

    @Test
    void letsMockListGet_throwAnException() {
        /* Mock List class */
        List mockList = Mockito.mock(List.class);
        /* when then */
        Mockito.when(mockList.get(anyInt()))
                .thenThrow(new RuntimeException("Something"));
        /* begin test */
        Class<RuntimeException> expected = RuntimeException.class;
        assertThrows(expected, () -> mockList.get(0));
    }
}
