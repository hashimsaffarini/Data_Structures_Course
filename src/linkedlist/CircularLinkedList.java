package linkedlist;

public class CircularLinkedList {

    static void display(Node head) {
        if (head == null) {
            return;
        }
        Node curr = head;
        do {
            System.out.print(curr.val + " ");
            curr = curr.next;
        } while (curr != head);
    }

    static boolean isCircular(Node head) {
        if (head == null) {
            return true;
        }

        Node curr = head.next;
        while (curr != null && curr != head) {
            curr = curr.next;
        }
        return (curr == head);
    }

    static Node convertSingleToCircular(Node head) {
        if (head == null) {
            return head;
        }
        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return head;
    }

    static Node exchangeNodes(Node head) {
        Node curr = head;
        while (curr.next.next != head) {
            curr = curr.next;
        }
        curr.next.next = head.next;
        head.next = curr.next;
        curr.next = head;
        head = head.next;
        return head;
    }

    static int countNodesInLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return countNodes(slow);
            }
        }
        return 0;
    }

    static int countNodes(Node n) {
        Node temp = n;
        int c = 0;
        do {
            c++;
            temp = temp.next;
        } while (temp != n);
        return c;
    }

    static Node[] splitNodes(Node head) {
        Node slow = head, fast = head;
        if (head == null) {
            return new Node[]{null, null};
        }

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next.next == head) {
            fast = fast.next;
        }
        Node head2 = null;
        if (head.next != head) {
            head2 = slow.next;
        }
        fast.next = head2;
        slow.next = head;
        return new Node[]{head, head2};
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1, 2, 3, 4, 5);
        list.head = convertSingleToCircular(list.head);
        display(list.head);
    }
}
