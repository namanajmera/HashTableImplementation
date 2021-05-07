package com.hashtableimplementation;

public class MyNode<K> implements AllNode<K> {
    private K key;
    private AllNode<K> next;

    public MyNode(K key) {
        this.key = key;
        this.next = null;
    }

    public AllNode<K> getNext() {
        return next;
    }

    public void setNext(AllNode next) {
        this.next = (AllNode<K>) next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

}
