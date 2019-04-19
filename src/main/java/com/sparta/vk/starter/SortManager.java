package com.sparta.vk.starter;

import com.sparta.vk.sorters.Sorter;
import com.sparta.vk.view.DisplayManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Random;


public class SortManager {

    private static Logger log = Logger.getLogger(SortManager.class.getName());

    private DisplayManager printArray = new DisplayManager();

    {
        PropertyConfigurator.configure("resources/log4j.properties");
    }

    public void SortArray(){

        log.trace("Sort Manager started \n");
        int[] unsortedArray = generateArray(20);
        Sorter sorter = SortFactory.getInstance();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray.clone());
        long end = System.nanoTime();
        printUnsortedArray(unsortedArray);
        printSortedArray(sortedArray, sorter.toString(), end-start);

    }

    private int[] generateArray(int size){

        Random random = new Random();
        int[] unsortedArray = new int[size];

        for(int i = 0; i < size; i++){
            unsortedArray[i] = random.nextInt(size* 5);
        }
        return unsortedArray;
    }

    private void printUnsortedArray(int[] unsortedArray){
        printArray.printUnsortedArray(unsortedArray);
    }

    private void printSortedArray(int[] sortedArray, String type, long time){
        printArray.printSortedArray(sortedArray, type, time);
    }

}
