package ru.clevertec.task.collection.customCollections;

import java.util.*;
import java.util.function.Consumer;

/**
 * A class that implements the CustomList interface. Custom version of ArrayList
 * @autor Denis Shpadaruk
 */
public class CustomArrayList<E> implements List<E> {

    /** default capacity */
    private static final int DEFAULT_CAPACITY = 5;

    /** array to store objects */
    private Object[] massiveObjects;

    /** number of objects  */
    private int size;

    /**
     * Constructor - creating a new object
     */
    public CustomArrayList() {
        this.massiveObjects = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Constructor - creating a new object
     * @param initialCapacity - size massive
     */
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

    /**
     * display all elements
     */
    public void show() {
        for(int i = 0; i < size; i++){
            System.out.println(massiveObjects[i]);
        }
    }

    /**
     * @return number of objects
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * check for emptiness
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * checking for the presence of an object in an array
     * @param o check for this object
     * @return true if found, false if otherwise
     */
    @Override
    public boolean contains(Object o) {
        if(o == null)
            throw new NullPointerException("object == null");

        for(int i = 0; i < size; i++){
            if(o.equals(massiveObjects[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * adding an object
     * @param e added object
     * @return
     */
    @Override
    public boolean add(E e) {
        int index = 0;
        boolean flag = true;
        while(index < massiveObjects.length && flag){
            if(massiveObjects[index] == null){
                massiveObjects[index] = e;
                size++;
                flag = false;
            }
            if (size == massiveObjects.length){
                ensureCapacity();
            }
            index++;
        }
        return flag;
    }



    /**
     * adding object by index
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);

        Object oldObjIndex = massiveObjects[index];
        massiveObjects[index] = element;

        for (; index <= size; index++) {
            Object obj = massiveObjects[index+1];
            massiveObjects[index+1] = oldObjIndex;
        }
    }

    /**
     * deleting an object by index
     * * @return remote object
     */
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

    /**
     * clears the array
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            massiveObjects[i] = null;

        size = 0;
    }

    /**
     * get object by index
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) massiveObjects[index];
    }

    /**
     * replaces an object by index
     * @param index - index in array
     * @param element - object to replace
     * @return
     */
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);

        massiveObjects[index] = element;
        return element;
    }


    /**
     * increasing the size of the array
     */
    private void ensureCapacity() {
        int newIncreasedCapacity = massiveObjects.length * 2;
        massiveObjects = Arrays.copyOf(massiveObjects, newIncreasedCapacity);
    }

///////////////////////////////////////
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
//        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
//        return Iterable.super.spliterator();
        return null;
    }

///////////////////////////////////
    @Override
    public boolean remove(Object o) {

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /////////////////////////////////////////////////////////////
    /**
     * custom iterator that implements two methods hasNext() and next()
     */
    private class MyArrayListIterator<E> implements Iterator<E> {
        private int currentIndex = 0;

        public MyArrayListIterator() {
        }

        public boolean hasNext() {
            return currentIndex < size;
        }

        public E next() {
            currentIndex++;
                return (E) massiveObjects[currentIndex++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
