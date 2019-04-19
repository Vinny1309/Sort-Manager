package com.sparta.vk.starter;


import com.sparta.vk.sorters.BubbleSorter;
import com.sparta.vk.sorters.Sorter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class SortFactory {

    enum sortTypes{
        BUBBLE("bubble"),
        MERGE("merge"),
        BINARY("binary");

        private String type;

        sortTypes(String type){
            this.type = type;
        }

        public String getType(){
            return type;
        }
    }

    private SortFactory(){

    }

    public static Sorter getInstance()  {

        try {
            Properties properties = new Properties();
            properties.load(new FileReader("resources/factory.properties"));
            String sorter = properties.getProperty("sortType");
            Class selectedSorter = Class.forName(sorter);
            return (Sorter) selectedSorter.getDeclaredConstructor().newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return new BubbleSorter();
    }
}