package com.hashtableimplementation;

public class MyLinkedList<K> {
    private AllNode head;
    private AllNode tail;

    public AllNode getHead() {
        return head;
    }

    public AllNode getTail() {
        return tail;
    }

    public MyLinkedList() {
        this.head = head;
        this.tail = tail;
    }

    public void add(AllNode newNode) {
        if (tail == null)
            this.tail = newNode;
        if (head == null)
            this.head = newNode;
        else {
            AllNode tempNode = this.head;
            this.head = newNode;
            newNode.setNext(tempNode);
        }
    }

    public <K extends Comparable<K>> void addOrdered(AllNode newNode) {
        if (head == null || (((Comparable<K>) head.getKey()).compareTo((K) newNode.getKey()) >= 0)) {
            newNode.setNext(head);
            this.head = newNode;
        } else {
            AllNode tempNode = head;
            while (tempNode.getNext() != null
                    && (((Comparable<K>) tempNode.getNext().getKey()).compareTo((K) newNode.getKey())) < 0) {
                tempNode = tempNode.getNext();
            }
            if (tempNode.getNext() == null) {
                AllNode myNode = search(tempNode.getKey());
                myNode.setNext(newNode);
                this.tail = newNode;
            } else {
                newNode.setNext(tempNode.getNext());
                AllNode myNode = search(tempNode.getKey());
                myNode.setNext(newNode);
            }
        }
    }

    public void append(AllNode newNode) {
        if (head == null)
            this.head = newNode;
        if (tail == null)
            this.tail = newNode;
        else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    public void printMyList() {
        System.out.print("My List is : ");
        StringBuffer myList = new StringBuffer();
        AllNode tempNode = head;
        while (!tempNode.equals(tail)) {
            myList.append(tempNode.getKey());
            myList.append("->");
            tempNode = tempNode.getNext();
        }
        myList.append(tempNode.getKey());
        System.out.println(myList);
    }

    public void insert(AllNode myNode, AllNode newNode) {
        AllNode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
    }

    public AllNode deleteTop() {
        AllNode tempNode = this.head;
        this.head = head.getNext();
//		System.out.println("Deleted element is :" + tempNode.getKey());
        return tempNode;
    }

    public AllNode deleteBottom() {
        AllNode tempNode = head;
        while (!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tail.setNext(null);
        tempNode = tempNode.getNext();
//		System.out.println("Deleted element is :" + tempNode.getKey());
        return tempNode;
    }

    public <K> AllNode search(K key) {
        AllNode tempNode = head;
        while (tempNode != null && tempNode.getNext() != null) {
            if (tempNode.getKey().equals(key)) {
//				System.out.println("Element is present");
                return tempNode;
            }
            tempNode = tempNode.getNext();
            if (tempNode.getKey().equals(key)) {
//				System.out.println("Element is present");
                return tempNode;
            }
        }
//		System.out.println("Element is not present");
        return null;
    }

    public void insertAfter(K myKey, K newKey) {
        AllNode myNode = search(myKey);
        if (myNode != null) {
            insert(myNode, new MyNode(newKey));
            System.out.println("Element inserted");
        } else
            System.out.println("Element not inserted");
    }

    public void deleteElement(K key) {
        AllNode deleteNode = search(key);
        AllNode tempNode = head;
        if (deleteNode != null) {
            if (head.getKey().equals(deleteNode.getKey()))
                deleteTop();
            else if (tail.getKey().equals(deleteNode.getKey()))
                deleteBottom();
            else {
                while (!tempNode.getNext().getKey().equals(deleteNode.getKey())) {
                    tempNode = tempNode.getNext();
                }
                tempNode.setNext(deleteNode.getNext());
            }
        }
    }

    public int size() {
        int size = 0;
        AllNode tempNode = head;
        while (tempNode != null) {
            size++;
            tempNode = tempNode.getNext();
        }
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListNodes{" + head + "}";
    }
}