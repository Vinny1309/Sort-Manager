package com.sparta.vk;

import com.sparta.vk.sorters.BubbleSorter;
import com.sparta.vk.sorters.Sorter;
import org.junit.Test;

import static org.junit.Assert.*;


public class BubbleSortTester {

    private Sorter sorter = new BubbleSorter();

    @Test
    public void testLength(){
        int[] unsorted = {3,1,7,5,2,8};
        //Sorter sorter = new BubbleSorter();
        int[] sorted = sorter.sortArray(unsorted);
        assertEquals(unsorted.length, sorted.length);
    }

    @Test
    public void testEmptyArray(){
        int[] unsorted = {};
        int[] sorted = sorter.sortArray(unsorted);
        assertArrayEquals(unsorted, sorted);
       // assertEquals(0, sorted.length);  Can also do this.
    }

//    @Test
//    public void testIsSorted(){
//        //int[] unsorted = {6,3,7,2,9};
//        int[] expected = {2,3,6,7,9};
//        int[] sorted = sorter.sortArray(expected);
//        //assertArrayEquals(expected, sorted);
//        assertSame(expected, sorted);
//    }

    @Test
    public void testAlreadySorted(){
        int[] unsorted = {1,2,7,3,4,5};
        int[] actuallySorted = sorter.sortArray(unsorted);
        for(int i = 0; i < actuallySorted.length - 1; i++){
            assertTrue(actuallySorted[i] < actuallySorted[i+1]);
        }
    }

    @Test
    public void testDuplicates(){
        int[] unsorted = {2,5,7,7,7,3,5,2,3,5,4};
        int[] sorted = sorter.sortArray(unsorted);
        for(int i = 0; i < sorted.length - 1; i++){
            if(sorted[i] < sorted[i+1]){
                assertTrue(sorted[i] <= sorted[i+1]);
            }
        }
    }

    @Test
    public void testZero(){
        int[] unsorted = {5,1,0,6,8,3,2};
        int[] sorted = sorter.sortArray(unsorted);
        for(int i = 0; i < sorted.length - 1; i++) {
            assertTrue(sorted[i] < sorted[i + 1]);
        }
    }

    @Test
    public void testNegativeNumbers(){
        int[] unsorted = {6, -3, 63, -8, 2};
        int[] sorted = sorter.sortArray(unsorted);
        for(int i = 0; i < sorted.length - 1; i++) {
            assertTrue(sorted[i] < sorted[i + 1]);
        }
    }

    @Test
    public void testName(){
        String message = sorter.toString();
        assertEquals("Bubble Sorter ", message);
    }

}
