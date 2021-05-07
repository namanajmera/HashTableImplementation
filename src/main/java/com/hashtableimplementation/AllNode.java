package com.hashtableimplementation;

public interface AllNode<K> {

    public K getKey();

    public void setKey(K key);

    public AllNode getNext();

    public void setNext(AllNode next);
}
