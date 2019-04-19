package com.sparta.vk.sorters;

import java.util.Random;

public class BubbleSorter implements Sorter{

    //Using nested for loop

    private int [] getBubbleSort(int[] array) {

        int temp = 0;
        int n = array.length;
        boolean isSorted = false;

        do {
            isSorted = false;
            for (int i = 1; i < n; i++) {
                //for (int j = 1; j < n; j++) {
                    if (array[i - 1] > array[i]) {
                        temp = array[i - 1];
                        array[i - 1] = array[i];
                        array[i] = temp;
                        isSorted = true;
                    }
            }
        } while (isSorted);
        return array;
    }

    @Override
    public int[] sortArray(int[] unsortedArray) {
        return getBubbleSort(unsortedArray);
    }

    @Override
    public String toString() {
        return "Bubble Sorter ";
    }
}
