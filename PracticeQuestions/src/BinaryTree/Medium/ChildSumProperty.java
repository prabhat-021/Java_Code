package BinaryTree.Medium;

public class ChildSumProperty {
    public static void main(String[] args) {

    }

    public static class Node {
        int data;
        Node left;
        Node right;
    }

    public static void changeTree(Node root) {
        chnage(root);
    }

    public static void chnage(Node root) {
        if (root == null) return;
        int sum = 0;
        if (root.left != null) sum += root.left.data;
        if (root.right != null) sum += root.right.data;

        if (root.data <= sum) {
            root.data = sum;
        } else {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        chnage(root.left);
        chnage(root.right);

        int tot = 0;
        if (root.left != null) tot += root.left.data;
        if (root.right != null) tot += root.right.data;
        if (root.left != null || root.right != null) root.data = tot;
    }
}
