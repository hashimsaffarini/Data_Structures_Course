package linkedlist;

public class MyLinkedList {


    public Node head;
    Node tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    void add(int... val) {
        for (int i = 0; i < val.length; i++) {
            add(val[i]);
        }
    }

//    void add(int... val) {
//        Node dummy = new Node(0);
//        Node cur = dummy;
//        for (int i = 0; i < val.length; i++) {
//            cur.next = new Node(val[i]);
//            cur = cur.next;
//        }
//        head = dummy.next;
//        tail = cur;
//    }

    public void add(int val) {
        Node newNode = new Node(val); //node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void addFirst(int val) {
        Node newNode = new Node(val); //node
        newNode.next = head;
        head = newNode;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    int indexOf(int val) {
        Node curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.val == (val)) {
                return i;
            }
            curr = curr.next;
        }
        return -1;
    }

    boolean contains(int val) {

        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.val == (val)) {
                return true;
            }
        }
        return false;
    }

    int getFirst() {
        if (head == null) {
            throw new NullPointerException();
        }
        return head.val;
    }

    int getLast() {
        if (tail == null) {
            throw new NullPointerException();
        }
        return tail.val;
    }

    int size() {
        return size;
    }

    int removeFirst() {
        if (head == null) {
            throw new NullPointerException();
        }
        int oldValue = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return oldValue;
    }

    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    void add(int index, int val) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(val);
        } else if (index == size) {
            add(val);
        } else {
            Node newNode = new Node(val);
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            int old = current.next.val;
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
        Node temp = head;
        while (temp != null) {
            res += temp.val + " ";
            temp = temp.next;
        }
        return res;
    }
}
