package ru.clevertec.task.collection.customCollections;

public class CustomNode<E> {
    private E data;
    private CustomNode next;

    //Constructor which takes an int value which is stored as the    data in this Node object.
    CustomNode(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public CustomNode getNext() {
        return next;
    }

    public void setNext(CustomNode next) {
        this.next = next;
    }
}
