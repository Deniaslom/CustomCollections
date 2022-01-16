package ru.clevertec.task.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.printf("Hello world");
        List arrayList = new ArrayList();
        List linkedList = new LinkedList();

        String[] str = new String[10];
        str[0] = "123";
        str[1] = "234";
        str[2] = "345";

        System.out.println(Arrays.stream(str).count());
        System.out.println(str[4]);

    }
}
