package ru.clevertec.task.collection.customCollections;

import ru.clevertec.task.collection.customCollections.interfaces.CustomIterator;
import ru.clevertec.task.collection.customCollections.interfaces.CustomList;

/**
 * A class that implements the CustomList interface. Custom version of LinkedList *
 * @autor Denis Shpadaruk
 */
public class CustomLinkedList<E> implements CustomList<E> {

    private CustomNode node;

    /**
     * Constructor - creating a new object
     */
    public CustomLinkedList() {
    }

    /**
     * display all elements
     */
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

    /**
     * @return number of objects
     */
    @Override
    public int size() {
        int size = 0;
        CustomNode oldNode = node;

        if (!isEmpty()) {
            size = 1;
        }

        while (getIterator().hasNext()) {
            getIterator().next();
            size++;
        }
        node = oldNode;
        return size;
    }

    /**
     * check for emptiness
     *
     * @return boolean
     */
    @Override
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
    @Override
    public boolean contains(Object o) {
        if (isEmpty()) {
            return false;
        }

        if (node.getData().equals(o)) {
            return true;
        }

        while (getIterator().hasNext()) {
            CustomNode findNode = (CustomNode) getIterator().next();
            if (findNode.getData().equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * adding an object
     *
     * @param e added object
     */
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

    /**
     * adding object by index
     */
    @Override
    public void add(int index, E element) {
        if (index <= size() && index >= 0) {
            int i = 0;
            while (getIterator().hasNext() && index >= i) {
                i++;
                getIterator().next();
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

    /**
     * clears the array
     */
    @Override
    public void clear() {
        node.setData(null);
        while (getIterator().hasNext()) {
            CustomNode next = (CustomNode) getIterator().next();
            next.setData(null);
        }
    }

    /**
     * get object by index
     */
    @Override
    public E get(int index) {
        if (index >= 0) {
            for (int i = 0; i <= index; i++) {
                if (getIterator().hasNext()) {
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
            while (getIterator().hasNext() && index >= i) {
                i++;
                getIterator().next();
                if (index == i) {
                    node.setData(element);
                }
            }
        }
        return (E) node.getData();
    }

    /**
     * custom iterator that implements two methods hasNext() and next()
     */
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
}
