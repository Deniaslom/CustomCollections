package ru.clevertec.task.collection.customCollections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.clevertec.task.collection.customCollections.interfaces.CustomList;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest {
    private CustomList<String> list = new CustomLinkedList<>();

    @BeforeEach
    public void start() {
        list.add("String 0");
        list.add("String 1");
        list.add("String 2");
        list.add("String 3");
    }


    @Test
    public void checkTrueMethodContains() {
        assertTrue(list.contains("String 0"));
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