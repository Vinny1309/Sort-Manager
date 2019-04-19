package com.sparta.vk.sorters;


import com.sparta.vk.BST.BinarySearch;
import com.sparta.vk.BST.BinaryTree;

import java.util.List;

public class BSTSorter implements Sorter {

    @Override
    public int[] sortArray(int[] unsortedArray) {
        BinaryTree tree = new BinarySearch();
        tree.addElements(unsortedArray);
        List<Integer> sortedArray = tree.getSortedTreeAsc();
        int[] array = new int[sortedArray.size()];
        for(int i=0; i < array.length; i++){
            array[i] = sortedArray.get(i);
        }
        return array;
    }

    @Override
    public String toString() {
        return "Binary Sorter ";
    }
}
