package linkedlist;

public class LinkedListProblems {


    static boolean isSorted(Node<Integer> head) {
        for (Node<Integer> curr = head; curr.next != null; curr = curr.next) {
            if (curr.val > curr.next.val) {
                return false;
            }
        }
        return true;
    }

    static boolean isSortedAnyWay(Node<Integer> head) {
        boolean f1 = true, f2 = true;
        for (Node<Integer> curr = head; curr.next != null; curr = curr.next) {
            if (curr.val > curr.next.val) {
                f1 = false;
            } else if (curr.val < curr.next.val) {
                f2 = false;
            }
        }
        return f1 || f2;
    }


    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10, -1, 20, 30);
        System.out.println(list);
        System.out.println(isSorted(list.head));
    }
}
