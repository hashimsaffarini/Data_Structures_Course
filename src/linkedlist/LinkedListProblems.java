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

    static Node reverseFromIndex(int index, Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        curr.next = reverse(curr.next);
        return head;
    }

    static Node insertNode(int val, Node head) {
        Node cur = head;
        Node nod = new Node(val);
        if (head == null || head.val >= nod.val) {
            nod.next = head;
            head = nod;
            return head;
        }

        while (cur.next != null) {
            if (cur.next.val > nod.val) {
                break;
            }
            cur = cur.next;
        }
        nod.next = cur.next;
        cur.next = nod;
        return head;
    }

    static Node removeDublicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;

        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    static Node[] alternatingSplit(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node c1 = head;
        Node c2 = head.next;
        Node h1 = head;
        Node h2 = head.next;

        while (c1.next != null && c2.next != null) {
            c1.next = c1.next.next;
            c1 = c1.next;
            c2.next = c2.next.next;
            c2 = c2.next;
        }
        if (c1 != null) {
            c1.next = null;
        }
        if (c2 != null) {
            c2.next = null;
        }
        return new Node[]{h1, h2};
    }

    static Node shuffleMerge(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (true) {
            if (a == null) {
                tail.next = b;
                break;
            } else if (b == null) {
                tail.next = a;
                break;
            } else {
                tail.next = a;
                tail = a;
                a = a.next;

                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
        return dummy.next;
    }

    static Node sortON(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node dummyZero = new Node(0);
        Node curZero = dummyZero;
        Node dummyOne = new Node(0);
        Node curOne = dummyOne;
        Node dummyTwo = new Node(0);
        Node curTwo = dummyTwo;

        Node cur = head;
        while (cur != null) {
            if (cur.val == 0) {
                curZero.next = new Node(0);
                curZero = curZero.next;
            } else if (cur.val == 1) {
                curOne.next = new Node(1);
                curOne = curOne.next;
            } else if (cur.val == 2) {
                curTwo.next = new Node(2);
                curTwo = curTwo.next;
            }
            cur = cur.next;
        }

        curZero.next = dummyOne.next;
        curOne.next = dummyTwo.next;
        return dummyZero.next;

    }

    static Node sortedMoerge(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        return dummy.next;
    }

    static Node sortedIntersection(Node a, Node b) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (a != null && b != null) {
            if (a.val == b.val) {
                current.next = new Node(a.val);
                current = current.next;
                a = a.next;
                b = b.next;
            } else if (a.val < b.val) {
                a = a.next;
            } else {
                b = b.next;
            }
        }
        return dummy.next;

    }

    static Node kSortedMerge() {
        MyLinkedList arr[] = new MyLinkedList[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new MyLinkedList();
        }
        arr[0].add(10, 20, 30);
        arr[1].add(1, 25, 35);
        arr[2].add(0, 7, 27, 59);

        Node result = arr[0].head;
        for (int i = 1; i < arr.length; i++) {
            result = sortedMoerge(result, arr[i].head);
        }
        return result;
    }

    static Node findKthNode(int k, Node head) {
        Node fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node firstHalf = middle(head);
        Node secHalf = firstHalf.next;
        firstHalf.next = null;
        secHalf = reverse(secHalf);

        while (secHalf != null) {
            if (secHalf.val != head.val) {
                return false;
            }
            secHalf = secHalf.next;
            head = head.next;
        }
        return true;
    }

    static boolean isCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = head;

        System.out.println(isCycle(head));
    }
}
