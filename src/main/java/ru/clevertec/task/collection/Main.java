package ru.clevertec.task.collection;

import ru.clevertec.task.collection.customCollections.CustomArrayList;
import ru.clevertec.task.collection.customCollections.CustomLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List lst = new LinkedList();
        List arr = new CustomArrayList();
        arr.add("str");
        arr.add("str");
        arr.add("str");
        arr.add("str");
//        List lin = new CustomLinkedList();
//        lin.add("atr22");
//        lin.add("atr22");
//        lin.add("atr22");
//        lin.add("atr22");
//        lin.add("atr22");

        for(Object o : arr){
            System.out.println(o);
        }

//        for(Object o : lin){
//
//        }


    }
}
