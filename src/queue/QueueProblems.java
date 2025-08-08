package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProblems {
    static void rotateLeft(Queue<Integer> q, int n) {
        int size = q.size();
        for (int i = 0; i < n % size; i++) {
            q.offer(q.remove());
        }
    }

    static void rotateRight(Queue<Integer> q, int n) {
        int size = q.size();
        for (int i = 0; i < size - n % size; i++) {
            q.offer(q.remove());
        }
    }

    static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.poll());
        }
        while (!s.isEmpty()) {
            q.offer(s.pop());
        }
    }

    static void printEvenOdd(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int x = q.poll();
            if (x % 2 == 0) {
                q.add(x);
            } else {
                s.push(x);
            }
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        System.out.println(q);
    }

    static void reverseFirstHalf(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            s.push(q.poll());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        rotateLeft(q, (size / 2) + size % 2);
    }

    static void swapBetweenEveryTwoNumbers(Queue<Integer> q) {
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            int x = q.poll();
            int y = q.poll();
            q.add(y);
            q.add(x);
        }
        if (size % 2 != 0) {
            q.add(q.poll());
        }
    }

    static void reverseEveryKth(Queue<Integer> q, int k) {
        int size = q.size();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < size / k; i++) {
            for (int j = 0; j < k; j++) {
                s.push(q.poll());
            }
            while (!s.isEmpty()) {
                q.add(s.pop());
            }
        }
    }


    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);

        System.out.println(q);
        reverseFirstHalf(q);
        System.out.println(q);
    }
}
