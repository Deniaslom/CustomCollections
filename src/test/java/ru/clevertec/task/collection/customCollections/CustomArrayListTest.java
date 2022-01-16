package ru.clevertec.task.collection.customCollections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {
    @Test
    public void testing(){
        CustomArrayList<String> list = new CustomArrayList(2);

        list.add("String 0");
        list.add("String 2");
        list.add("String 3");
        list.add("String 4");
        list.add("String 5");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
    }

}