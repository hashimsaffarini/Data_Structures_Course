package tree;

public class MyTree {

    public static void main(String[] args) {
        BST t  = new BST();
        t.add( 10);
        t.add(1);
        t.add(7);
        System.out.println(t.count());

        System.out.println(t);
    }
}
