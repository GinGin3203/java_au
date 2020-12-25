import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator<T>();
    }

    private class MyLinkedListIterator<T> implements Iterator<T> {
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            return (T) get(currentIndex++);
        }
    }

    private class Node {
        Node next;
        Node prev;
        T val;

        public Node(T data) {
            this.val = data;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
    }

    /**
     * Return node at a given index
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNodeAtIndex(int index) {
        Node travNode = head;
        while (index > 0) {
            index--;
            travNode = travNode.next;
        }
        return travNode;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public T get(int index) {
        if (index >= size)
            return null;

        return getNodeAtIndex(index).val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(T val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(T val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, T val) {
        if (index > size)
            return;

        if (index == size) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            size++;
            Node newNode = new Node(val);
            Node nodeAtIndex = getNodeAtIndex(index);
            newNode.prev = nodeAtIndex.prev;
            newNode.next = nodeAtIndex;
            nodeAtIndex.prev.next = newNode;
            nodeAtIndex.prev = newNode;
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size)
            return;

        if (index == 0) {
            head = head.next;
            if (size > 1)
                head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            if (size > 1)
                tail.next = null;
        } else {
            Node nodeAtIndex = getNodeAtIndex(index);
            nodeAtIndex.prev.next = nodeAtIndex.next;
            nodeAtIndex.next.prev = nodeAtIndex.prev;
        }
        size--;
    }


}

