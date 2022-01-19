package ru.clevertec.task.collection.customCollections;

import ru.clevertec.task.collection.customCollections.interfaces.CustomIterator;
import ru.clevertec.task.collection.customCollections.interfaces.CustomList;

import java.util.Arrays;

public class CustomArrayList<E> implements CustomList<E> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] massiveObjects;
    private int size;

    public CustomArrayList() {
        this.massiveObjects = new Object[DEFAULT_CAPACITY];
        this.size = DEFAULT_CAPACITY;
    }

    public CustomArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.massiveObjects = new Object[initialCapacity];
            this.size = initialCapacity;
        } else if (initialCapacity == 0) {
            this.massiveObjects = new Object[]{};
            this.size = 0;
        } else {
            throw new IllegalArgumentException("negative initial capacity: " +
                    initialCapacity);
        }
    }

    @Override
    public void show() {
        for(int i = 0; i < size; i++){
            System.out.println(massiveObjects[i]);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (massiveObjects.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        CustomIterator iterator = getIterator();
        int index = 0;
        boolean flag = false;

        while (iterator.hasNext()) {
            index++;
            if (o.equals(iterator.next())) {
                flag = true;
            }
        }

        return false;
    }

    @Override
    public void add(E e) {
        CustomIterator iterator = getIterator();
        int index = 0;

        while(iterator.hasNext()){
            iterator.next();
            index++;
        }

        if(index == massiveObjects.length){
            ensureCapacity();
            massiveObjects[index] = e;
        } else {
            massiveObjects[index] = e;
        }
    }

    @Override
    public void add(int index, E element) {
        if (size == massiveObjects.length)
            ensureCapacity();

        massiveObjects[size++] = element;
    }

    @Override
    public E remove(int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);


        E removedElement = (E) massiveObjects[index];
        for (int i = index; i < size - 1; i++) {
            massiveObjects[i] = massiveObjects[i + 1];
        }
        size--;
        return removedElement;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            massiveObjects[i] = null;

        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) massiveObjects[index];
    }


    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);

        massiveObjects[index] = element;
        return element;
    }




    private void ensureCapacity() {
        int newIncreasedCapacity = massiveObjects.length * 2;
        massiveObjects = Arrays.copyOf(massiveObjects, newIncreasedCapacity);
        size = massiveObjects.length;
    }

    @Override
    public CustomIterator<E> getIterator() {
        CustomIterator<E> iterator = new CustomIterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && massiveObjects[currentIndex] != null;
            }

            @Override
            public E next() {
                return (E) massiveObjects[currentIndex++];
            }

        };
        return iterator;
    }
}
