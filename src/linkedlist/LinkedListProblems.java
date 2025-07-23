package linkedlist;

public class LinkedListProblems {


    static boolean isSorted(Node head) {
        for (Node curr = head; curr.next != null; curr = curr.next) {
            if (curr.val > curr.next.val) {
                return false;
            }
        }
        return true;
    }

    static boolean isSortedAnyWay(Node head) {
        boolean f1 = true, f2 = true;
        for (Node curr = head; curr.next != null; curr = curr.next) {
            if (curr.val > curr.next.val) {
                f1 = false;
            } else if (curr.val < curr.next.val) {
                f2 = false;
            }
        }
        return f1 || f2;
    }

    static Node middle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node rotateLeftToRight(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        head = head.next;
        curr.next.next = null;
        return head;
    }

    static Node rotateRightToLeft(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next.next = head;
        head = curr.next;
        curr.next = null;
        return head;
    }

    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1, 2, 3, 4, 5);
        System.out.println(list);
        list.head = reverse(list.head);
        System.out.println(list);
    }
}
