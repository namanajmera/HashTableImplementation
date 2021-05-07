package com.hashtableimplementation;

import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {
    private final int arrayLength;
    ArrayList<MyLinkedList<K>> myHashArray;

    public MyLinkedHashMap() {
        arrayLength = 10;
        myHashArray = new ArrayList<>(arrayLength);
        initializeHashArray();
    }

    public void initializeHashArray() {
        for (int i = 0; i < arrayLength; i++)
            this.myHashArray.add(null);
    }

    private int getArrayIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int arrayIndex = hashCode % arrayLength;
        return arrayIndex;
    }

    public V get(K key) {
        int arrayIndex = this.getArrayIndex(key);
        MyLinkedList<K> myLinkedList = this.myHashArray.get(arrayIndex);
        if (myLinkedList == null)
            return null;
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    public void add(K key, V value) {
        int arrayIndex = this.getArrayIndex(key);
        MyLinkedList<K> myLinkedList = this.myHashArray.get(arrayIndex);
        if (myLinkedList == null) {
            myLinkedList = new MyLinkedList<>();
            this.myHashArray.set(arrayIndex, myLinkedList);
        }
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<>(key, value);
            myLinkedList.append(myMapNode);
        } else {
            myMapNode.setValue(value);
        }
    }

    public void deleteKey(K key) {
        int arrayIndex = this.getArrayIndex(key);
        MyLinkedList<K> myLinkedList = this.myHashArray.get(arrayIndex);
        if (myLinkedList == null) {
            System.out.println("Word not present");
        } else {
            MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
            if (myMapNode == null)
                System.out.println("Word not present");
            else {
                myLinkedList.deleteElement(key);
                System.out.println("Word deleted");
            }
        }
    }

    @Override
    public String toString() {
        return "MyLinkedHashMap List{" + myHashArray + "}";
    }

}
