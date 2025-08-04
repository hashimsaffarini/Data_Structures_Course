package stack;

import java.util.Stack;

public class StackMain {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop());
        System.out.println(s.pop());

        System.out.println(s);
        System.out.println(s.size());



    }
}
