package ru.clevertec.task.collection.customCollections;

import java.util.*;

/**
 * A class that implements the CustomList interface. Custom version of LinkedList *
 *
 * @autor Denis Shpadaruk
 */
public class CustomLinkedList<E> implements List<E> {

    private CustomNode<E> node;

    /**
     * Constructor - creating a new object
     */
    public CustomLinkedList() {
    }

    /**
     * display all elements
     */
    public void show() {
        CustomNode currentNode = node;
        if (currentNode == null) {
            System.out.println("Linked list is empty");
        } else {
            while (currentNode != null) {
                System.out.print(currentNode.getData() + " ");
                currentNode = currentNode.getNext();
            }
        }
    }

    /**
     * @return number of objects
     */
    public int size() {
        int size = 0;
        MyLinkedListIterator itr = new MyLinkedListIterator(node);

        if(!isEmpty()){
            size++;
        }

        while (itr.hasNext()) {
            itr.next();
            size++;
        }
        return size;
    }

    /**
     * check for emptiness
     *
     * @return boolean
     */
    public boolean isEmpty() {
        if (node.getData() == null) {
            return true;
        }
        return false;
    }

    /**
     * checking for the presence of an object in an array
     *
     * @param o check for this object
     * @return true if found, false if otherwise
     */
    public boolean contains(Object o) {
        MyLinkedListIterator itr = new MyLinkedListIterator(node);
        if (isEmpty()) {
            return false;
        }

        if (node.getData().equals(o)) {
            return true;
        }

        while (itr.hasNext()) {
            CustomNode findNode = (CustomNode) itr.next();
            if (findNode.getData().equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator<>(node);
    }

    /**
     * adding an object
     *
     * @param e added object
     */
    public boolean add(E e) {
        MyLinkedListIterator itr = new MyLinkedListIterator(node);
        CustomNode targetNode = node;

        if (node == null) {
            node = new CustomNode(e);
            return true;
        }

        while (itr.hasNext()) {
            targetNode = (CustomNode) itr.next();
        }

        if (targetNode.getNext() == null) {
            targetNode.setNext(new CustomNode(e));
            return true;
        }

        return false;
    }



    /**
     * adding object by index
     */
    public void add(int index, E element) {
        if (index <= size() && index >= 0) {
            int i = 0;
            while (listIterator().hasNext() && index >= i) {
                i++;
                listIterator().next();
                if (index == i) {
                    CustomNode oldNode = new CustomNode(node.getData());
                    node.setData(element);
                    node.setNext(oldNode);
                }
            }
        }
    }

    /**
     * deleting an object by index
     * * @return remote object
     */
    public E remove(int index) {
        if (index == 0) {
            node = node.getNext();
        } else {
            CustomNode currentNode = node;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
        }
        return (E) node;
    }

    /**
     * get object by index
     */
    public E get(int index) {
        if (index >= 0) {
            for (int i = 0; i <= index; i++) {
                if (listIterator().hasNext()) {
                    E findNode = listIterator().next();
                    if (index == (i + 1)) {
                        return findNode;
                    }
                } else {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
        }
        return null;
    }

    /**
     * replaces an object by index
     *
     * @param index   - index in array
     * @param element - object to replace
     * @return
     */
    @Override
    public E set(int index, E element) {
        if (index <= size() && index >= 0) {
            int i = 0;
            while (listIterator().hasNext() && index >= i) {
                i++;
                listIterator().next();
                if (index == i) {
                    node.setData(element);
                }
            }
        }
        return (E) node.getData();
    }

    /**
     * clears the array
     */
    public void clear() {
        MyLinkedListIterator itr = new MyLinkedListIterator(node);

        if(node !=null){
            node.setData(null);
        }

        while (itr.hasNext()) {
            CustomNode next = (CustomNode) itr.next();
            next.setData(null);
        }
    }
//Методы не реализованы!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
        return (ListIterator<E>) new MyLinkedListIterator<E>(node);
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

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    //Методы не реализованы!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//    public CustomIterator<E> getIterator() {
//        CustomIterator<E> iterator = new CustomIterator<E>() {
//
//            @Override
//            public boolean hasNext() {
//                if (node.getNext() != null)
//                    return true;
//                else
//                    return false;
//            }
//
//            @Override
//            public E next() {
//                node = node.getNext();
//                return (E) node;
//            }
//
//            public void remove() {
//                throw new UnsupportedOperationException();
//            }
//
//        };
//        return iterator;
//    }

    private class MyLinkedListIterator<E> implements ListIterator<E> {
        private CustomNode iterNode;

        public MyLinkedListIterator() {
        }

        public MyLinkedListIterator(CustomNode node) {
            this.iterNode = node;
        }

        @Override
        public boolean hasNext() {
            if (iterNode.getNext() != null)
                return true;
            else
                return false;
        }

        @Override
        public E next() {
            iterNode = iterNode.getNext();
            return (E) iterNode;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }

    }
}
