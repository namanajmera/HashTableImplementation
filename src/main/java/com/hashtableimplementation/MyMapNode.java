package com.hashtableimplementation;

public class MyMapNode<K, V> implements AllNode<K> {
    K key;
    V value;
    MyMapNode<K, V> next;

    public MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public AllNode getNext() {
        return next;
    }

    @Override
    public void setNext(AllNode next) {
        this.next = (MyMapNode<K, V>) next;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder myMapNodeString = new StringBuilder();
        myMapNodeString.append("MyMapNode{K=").append(key).append("|V=").append(value).append("}");
        if (next != null)
            myMapNodeString.append("->").append(next);
        return myMapNodeString.toString();
    }

}