package tree;

import java.util.List;

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

    boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    int countLeaf(Node root) {
        if (root == null) return 0;
        else if (isLeaf(root)) {
            return 1 + countLeaf(root.left) + countLeaf(root.right);
        }
        return countLeaf(root.left) + countLeaf(root.right);
    }

    int countLeaf() {
        return countLeaf(root);
    }

    int maxo(Node root) {//BT
        if (root == null) return Integer.MIN_VALUE;

        return Math.max(root.val, Math.max(maxo(root.left), maxo(root.right)));
    }

    int maxo2(Node root) {//BST
        Node curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.val;
    }

    boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.val == key) {
            return true;
        }
        return search(root.left, key) || search(root.right, key);
    }

    boolean search(int key) {
        return search(root, key);
    }

    boolean searchBST(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.val > key) {
            return searchBST(root.left, key);
        } else if (root.val < key) {
            return searchBST(root.right, key);
        }
        return true;
    }

    boolean isSymmetric(Node root) {
        return isMirror(root.left, root.right);
    }

    boolean isMirror(Node a, Node b) {
        if (a == null || b == null) {
            return a == b;
        }
        if (a.val != b.val) {
            return false;
        }
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    boolean isSameTree(Node a, Node b) {
        if (a == null || b == null) {
            return a == b;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    boolean hasPathSum(Node root, int sum) {
        if (root == null) return false;
        else if (isLeaf(root) && sum - root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
//    List<List<Integer>> levelOrder(Node root) {
//
//    }

    @Override
    public String toString() {
        return print(root, "");
    }
}
