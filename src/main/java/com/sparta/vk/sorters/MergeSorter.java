package com.sparta.vk.sorters;

public class MergeSorter implements Sorter{

    public static int[] mergeSort(int[] array) {

        int midPoint = array.length/2;
        int[] array1 = new int[midPoint];
        int[] array2 = new int [array.length - midPoint];
        int i = 0, j = 0, k = 0;

        if(array.length > 1) {

            for (int n = 0; n < midPoint; n++) {
                array1[n] = array[n];
            }


            for (int n = midPoint; n < array.length; n++) {
                array2[n - midPoint] = array[n];
            }

            mergeSort(array1);
            mergeSort(array2);

            while(i < array1.length && j < array2.length){
                if(array1[i] <= array2[j]){
                    array[k++] = array1[i++];
                }

                else if (array1[i] > array2[j]){
                    array[k++] = array2[j++];
                }
            }

            while(i < array1.length)
                array[k++] = array1[i++];

            while(j < array2.length)
                array[k++] = array2[j++];
        }
        return array;
    }

    @Override
    public int[] sortArray(int[] unsortedArray) {
        return mergeSort(unsortedArray);
    }

    @Override
    public String toString() {
        return " Recursive Merge Sorter ";
    }
}