package tree;

public class BST {

    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    Node root;

    Node add(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val > root.val) {
            root.right = add(root.right, val);
        } else if (val < root.val) {
            root.left = add(root.left, val);
        }
        return root;
    }

    void add(int val) {
        root = add(root, val);
    }

    String print(Node root, String s) {
        if (root == null) {
            return s;
        }
        s = print(root.left, s);
        s += (root.val + " ");
        s = print(root.right, s);
        return s;
    }

    int count(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    int count() {
        return count(root);
    }

    @Override
    public String toString() {
        return print(root, "");
    }
}
