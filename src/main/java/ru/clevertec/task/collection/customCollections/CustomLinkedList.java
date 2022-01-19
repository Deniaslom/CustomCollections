package ru.clevertec.task.collection.customCollections;

import ru.clevertec.task.collection.customCollections.interfaces.CustomIterator;
import ru.clevertec.task.collection.customCollections.interfaces.CustomList;

public class CustomLinkedList<E> implements CustomList<E> {
    private CustomNode node;

    public CustomLinkedList() {
    }

    @Override
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

    @Override
    public int size() {
        int size = 0;
        CustomNode oldNode = node;

        if(!isEmpty()){
            size = 1;
        }

        while(getIterator().hasNext()){
            getIterator().next();
            size++;
        }
        node = oldNode;
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (node.getData() == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if(isEmpty()){
            return false;
        }

        if(node.getData().equals(o)){
            return true;
        }

        while(getIterator().hasNext()){
            CustomNode findNode = (CustomNode) getIterator().next();
            if(findNode.getData().equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(E e) {
        CustomNode newNode = new CustomNode(e);
        if (node == null) {
            node = newNode;
        } else {
            CustomNode currentNode = node;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
    }

    @Override
    public void clear() {
        node.setData(null);
        while(getIterator().hasNext()){
            CustomNode next = (CustomNode) getIterator().next();
            next.setData(null);
        }
    }

    @Override
    public CustomIterator<E> getIterator() {
        CustomIterator<E> iterator = new CustomIterator<E>() {

            @Override
            public boolean hasNext() {
                if (node.getNext() != null)
                    return true;
                else
                    return false;
            }

            @Override
            public E next() {
                node = node.getNext();
                return (E) node;
            }

        };
        return iterator;
    }

    @Override
    public E get(int index) {
        if(index >= 0){
            for (int i = 0; i <= index; i++){
                if(getIterator().hasNext()) {
                    E findNode = getIterator().next();
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

    @Override
    public E set(int index, E element) {
        if(index <= size() && index >= 0){
            int i = 0;
            while(getIterator().hasNext() && index >= i){
                i++;
                getIterator().next();
                if(index == i){
                    node.setData(element);
                }
            }
        }
        return (E) node.getData();
    }

    @Override
    public void add(int index, E element) {
        if(index <= size() && index >= 0){
            int i = 0;
            while(getIterator().hasNext() && index >= i){
                i++;
                getIterator().next();
                if(index == i){
                    CustomNode oldNode = new CustomNode(node.getData());
                    node.setData(element);
                    node.setNext(oldNode);
                }
            }
        }

    }

    @Override
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
}
