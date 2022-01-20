package ru.clevertec.task.collection.customCollections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest {
    private List<String> list = new CustomLinkedList<>();

    @BeforeEach
    public void start() {
        list.add("String 0");
        list.add("String 1");
        list.add("String 2");
        list.add("String 3");
    }


    @Test
    public void checkTrueMethodContains() {
        for (String str : list){
            System.out.println(str);
        }
        assertTrue(list.contains("String 0"));
        assertTrue(list.contains("String 1"));
        assertTrue(list.contains("String 2"));
        assertTrue(list.contains("String 3"));
    }

    @Test
    public void checkGetById(){
        assertTrue(list.get(0).equals("String 0"));
        assertTrue(list.get(1).equals("String 1"));
        assertTrue(list.get(2).equals("String 2"));
        assertTrue(list.get(3).equals("String 3"));
    }

    @Test
    public void checkFalseMethodContains() {
        assertFalse(list.contains("String 6"));
    }

    @Test
    public void checkSize() {
        assertTrue(list.size() == 4);
    }

    @Test
    public void checkSizeAfterAddElements() {
        list.add("String 7");
        list.add("String 8");
        assertTrue(list.size() == 6);
    }

    @Test
    public void checkSizeAfterRemoveElement() {
        list.remove(0);
        assertTrue(list.size() == 3);
    }


    @Test
    public void checkIsEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    public void checkIsEmptyAfterClear() {
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkAddAndContains() {
        list.add("String 10");
        assertTrue(list.contains("String 10"));
    }
}