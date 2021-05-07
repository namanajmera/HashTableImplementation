package com.hashtableimplementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyHashMapTest {
    @Test
    public void givenASentence_WhenWordsAreAddedToList_ShouldReturnWordFrequency() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        String sentence = "To be or not to be";
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = myHashMap.get(word);
            if (value == null)
                value = 1;
            else
                value++;
            myHashMap.add(word, value);
        }
        System.out.println(myHashMap.toString());
        Assertions.assertEquals(1, (int) myHashMap.get("or"));
    }
}
