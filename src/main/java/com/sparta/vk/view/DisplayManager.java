package com.sparta.vk.view;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.text.DecimalFormat;
import java.util.Arrays;

public class DisplayManager {

    private static Logger log = Logger.getLogger(DisplayManager.class.getName());

    {
        PropertyConfigurator.configure("resources/log4j.properties");
    }

    public void printUnsortedArray(int[] unsortedArray){
        log.trace("Unsorted Array created \n" + Arrays.toString(unsortedArray) + "\n");
        //System.out.println("Unsorted Array: \n" + Arrays.toString(unsortedArray));
    }

    public void printSortedArray(int[] sortedArray, String sorter, long timeTaken){
        DecimalFormat df = new DecimalFormat("###,###.####");

        log.trace("Sorted using " + sorter + "\n");
        log.trace("Sorted Array created \n" + Arrays.toString(sortedArray) + "\n");
        log.trace("Time taken to sort Array: \n" + df.format(timeTaken) + " ns");

        //System.out.println("Sorted using: " + sorter);
        //System.out.println(Arrays.toString(sortedArray));
        //System.out.println("Time taken = " + df.format(timeTaken));
    }
}
