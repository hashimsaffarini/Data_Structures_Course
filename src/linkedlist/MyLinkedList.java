package linkedlist;

public class MyLinkedList<T> {


    Node<T> head, tail;
    int size;

    MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    void add(T val) {
        Node<T> newNode = new Node<>(val); //node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void addFirst(T val) {
        Node<T> newNode = new Node<>(val); //node
        newNode.next = head;
        head = newNode;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    T getFirst() {
        if (head == null) {
            throw new NullPointerException();
        }
        return head.val;
    }

    T getLast() {
        if (tail == null) {
            throw new NullPointerException();
        }
        return tail.val;
    }

    T removeFirst() {
        if (head == null) {
            throw new NullPointerException();
        }
        T oldValue = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return oldValue;
    }

    T get(int index) {
        if (index < 0 || index >= size) {
            throw new NullPointerException();
        }

        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }


    @Override
    public String toString() {
        String res = "";
        Node<T> temp = head;
        while (temp != null) {
            res += temp.val + " ";
            temp = temp.next;
        }
        return res;
    }
}
