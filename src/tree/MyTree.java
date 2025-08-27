package tree;

public class MyTree {

    public static void main(String[] args) {
        BST t  = new BST();
        t.add(10);
        t.add(20);
        t.add(1);
        t.add(2);
        System.out.println(t.countLeaf());
    }
}
