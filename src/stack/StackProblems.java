package stack;

import java.util.Stack;

public class StackProblems {
    static int count(Stack<Integer> s) {
        int c = 0;
        Stack<Integer> a = new Stack<>();
        while (!s.isEmpty()) {
            c++;
            a.push(s.pop());
        }
        while (!a.isEmpty()) {
            s.push(a.pop());
        }
        return c;
    }

    static void swapBetweenFirstAndLast(Stack<Integer> s) {
        int x = s.pop();
        Stack<Integer> a = new Stack<>();
        while (!s.isEmpty()) {
            a.push(s.pop());
        }
        int y = a.pop();
        s.push(x);
        while (!a.isEmpty()) {
            s.push(a.pop());
        }
        s.push(y);
    }

    static void rotateFromBottomToTop(Stack<Integer> s) {
        Stack<Integer> a = new Stack<>();
        while (!s.isEmpty()) {
            a.push(s.pop());
        }
        int x = a.pop();
        while (!a.isEmpty()) {
            s.push(a.pop());
        }
        s.push(x);
    }

    static void rotateFromTopToBottom(Stack<Integer> s) {
        Stack<Integer> a = new Stack<>();
        int x = a.pop();
        while (!s.isEmpty()) {
            a.push(s.pop());
        }
        s.push(x);
        while (!a.isEmpty()) {
            s.push(a.pop());
        }
    }

    static Stack<Integer> copyStack(Stack<Integer> s) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        while (!s.isEmpty()) {
            b.push(s.pop());
        }

        while (!b.isEmpty()) {
            int val = b.pop();
            s.push(val);
            a.push(val);
        }
        return a;
    }

    static boolean isPalindrome(Stack<Integer> s) {
        int size = count(s);
        Stack<Integer> a = new Stack<>();
        for (int i = 0; i < size / 2; i++) {
            a.push(s.pop());
        }

        if (size % 2 != 0) {
            s.pop();
        }
        while (!s.isEmpty()) {
            if (s.pop() != a.pop()) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println(isPalindrome(s));
    }
}
