package linkedlist;

public class LinkedListMain {

    public static void main(String[] args) {
        Node a = new Node(10);
        a.next = new Node(20);
        a.next.next = new Node(30);
        Node temp = a;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }


        // 10 -> 20 -> 30 -> null


    }
}
