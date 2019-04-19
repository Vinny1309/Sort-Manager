package com.sparta.vk.BST;

import java.util.ArrayList;
import java.util.List;


public class BinarySearch implements BinaryTree {

    //private variable Node
    //Store node
    //store two child nodes(left and right)

    private Node root;
    private Node newNode;


    @Override
    public int getRootElement() {
        return root.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return getNumberOfElements(root);
    }

    private int getNumberOfElements(Node node){
        if(node == null)
            return 0;
        else
            return (getNumberOfElements(node.getLeft()) +1+ getNumberOfElements(node.getRight()));
    }

    @Override
    public void addElement(int element) {
        Node newNode = new Node(element);
        if(root == null){
            root = newNode;
        }
        addElement(root, newNode);
    }

    private void addElement(Node node, Node newNode){

        if(newNode.getValue() < node.getValue()){
            if(node.getLeft() == null){
                node.setLeft(newNode);
            }
            else if (node.getLeft() != null){
                addElement(node.getLeft(), newNode);
            }
        }
        else if(newNode.getValue() > node.getValue()){
            if(node.getRight() == null){
                node.setRight(newNode);
            }
            else{
                addElement(node.getRight(), newNode);
            }
        }
    }

    @Override
    public void addElements(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            addElement(elements[i]);
        }
    }

    @Override
    public boolean findElement (int value){
        return findElement(root, value);
    }

    private boolean findElement(Node element, int value){
        boolean found = false;
        while((element != null) && !found){
            int rightValue = element.getValue();
            if (value < rightValue)
                element = element.getLeft();
            else if (value > rightValue)
                element = element.getRight();
            else{
                found = true;
                break;
            }
            found = findElement(element,value);
        }
        return found;
    }

    @Override
    public int getLeftChild (int element){
        return getLeftChild(root, element);
    }

    private int getLeftChild(Node node, int element) {
        Node newNode = new Node(element);
        while (findElement(element) && node != null) {
            int rightValue = node.getValue();
            if (element < rightValue) {
                node = node.getLeft();
                element = node.getValue();
                getLeftChild(node, element);
            } else if (element > rightValue) {
                node = node.getRight();
                element = node.getValue();
                getLeftChild(node, element);
            }
//            else if( newNode.getLeft() == null){
//                //System.out.println("No child");
//                return null;
//            }
            else {
                return node.getLeft().getValue();
            }
        }
        //return null;
        return node.getValue();
    }

    @Override
    public int getRightChild (int element){
        return getRightChild(root, element);
    }

    private int getRightChild(Node node, int element){

        while (findElement(element) && node != null) {
            int rightValue = node.getValue();
            if (element < rightValue) {
                node = node.getLeft();
                getRightChild(node, element);
                element = node.getValue();
            } else if (element > rightValue) {
                node = node.getRight();
                getRightChild(node, element);
                element = node.getValue();
            } else if(node.getRight() == null){
                return 0;
            }
            else {
                return node.getRight().getValue();
            }
        }
        return node.getValue();
    }

    @Override
    public List<Integer> getSortedTreeAsc () {
        return getSortedTreeAsc(root);
    }

    private List<Integer> getSortedTreeAsc(Node node){
        if(node == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(getSortedTreeAsc(node.getLeft()));
        list.add(node.getValue());
        list.addAll(getSortedTreeAsc(node.getRight()));
        return list;
    }

    @Override
    public List<Integer> getSortedTreeDesc () {
        return getSortedTreeDesc(root);
    }

    private List<Integer> getSortedTreeDesc(Node node){
        if(node == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(getSortedTreeDesc(node.getRight()));
        list.add(node.getValue());
        list.addAll(getSortedTreeDesc(node.getLeft()));
        return list;
    }
}