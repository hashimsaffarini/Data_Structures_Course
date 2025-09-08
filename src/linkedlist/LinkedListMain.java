package linkedlist;

public class LinkedListMain {

    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}
