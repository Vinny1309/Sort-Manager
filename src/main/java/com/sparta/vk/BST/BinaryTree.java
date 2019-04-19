package com.sparta.vk.BST;

import java.util.List;

public interface BinaryTree {
    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element);

    int getRightChild(int element);

    List<Integer> getSortedTreeAsc();

    List<Integer> getSortedTreeDesc();
}
