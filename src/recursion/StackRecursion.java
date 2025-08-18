package recursion;

import java.util.Stack;

public class StackRecursion {

    static void printStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int x = s.pop();
        System.out.println(x);
        printStack(s);
        s.push(x);
    }

    static void addBottom(Stack<Integer> s, int y) {
        if (s.isEmpty()) {
            s.push(y);
            return;
        }
        int x = s.pop();
        addBottom(s, y);
        s.push(x);
    }

    static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) return;
        int y = s.pop();
        reverse(s);
        addBottom(s, y);
    }

    static void sortStack(Stack<Integer> s) {
        if (s.isEmpty()) return;
        int y = s.pop();
        sortStack(s);
        insertSorted(s, y);
    }

    static void insertSorted(Stack<Integer> s, int val) {
        if (s.isEmpty() || val >= s.peek()) {
            s.push(val);
            return;
        }
        int z = s.pop();
        insertSorted(s, val);
        s.push(z);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
}
