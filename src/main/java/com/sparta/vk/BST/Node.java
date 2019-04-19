package com.sparta.vk.BST;

public class Node {

    private final int value;
    private Node left;
    private Node right;


    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {

        return this.left;
    }

    public void setLeft(Node left) {

        this.left = left;
    }

    public Node getRight() {

        return this.right;
    }

    public void setRight(Node right) {

        this.right = right;
    }

}