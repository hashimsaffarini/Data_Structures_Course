package linkedlist;

public class LinkedListMain {

    public static void main(String[] args) {

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(-1);

        System.out.println(list.get(-1));
        System.out.println(list);

    }
}
