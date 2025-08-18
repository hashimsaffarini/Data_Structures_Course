package recursion;

import java.util.LinkedList;
import java.util.Queue;

public class QueueRecursion {
    static void printQueue(Queue<Integer> q) {
        if (q.isEmpty()) return;
        int x = q.poll();
        System.out.println(x);
        printQueue(q);
        q.add(x);
    }

    static void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty()) return;
        int x = q.poll();
        reverseQueue(q);
        q.add(x);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println(q);
        reverseQueue(q);
        System.out.println(q);
    }
}
