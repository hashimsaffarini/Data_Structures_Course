package recursion;

public class MyRecursion {

    static void fun(int n, char ch) {
        if (n == 0) return;
        System.out.println(n + " " + ch);
        fun(n - 1, 'L');
        fun(n - 1, 'R');
    }

    public static void main(String[] args) {
        fun(4, 'H');
    }
}
