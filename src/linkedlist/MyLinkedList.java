package linkedlist;

public class MyLinkedList<T> {


    Node<T> head, tail;
    private int size;

    MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    void add(T... val) {
        for (int i = 0; i < val.length; i++) {
            add(val[i]);
        }
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

    int indexOf(T val) {
        Node<T> curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.val.equals(val)) {
                return i;
            }
            curr = curr.next;
        }
        return -1;
    }

    boolean contains(T val) {

        for (Node<T> curr = head; curr != null; curr = curr.next) {
            if (curr.val.equals(val)) {
                return true;
            }
        }
        return false;
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

    int size() {
        return size;
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
            throw new IndexOutOfBoundsException();
        }

        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    void add(int index, T val) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(val);
        } else if (index == size) {
            add(val);
        } else {
            Node<T> newNode = new Node<>(val);
            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            T old = current.next.val;
            if (index == size - 1) {//last element
                tail = current;
            }
            current.next = current.next.next;
            size--;
            return old;
        }
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
