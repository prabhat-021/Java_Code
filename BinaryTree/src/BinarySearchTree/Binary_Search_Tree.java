package BinarySearchTree;

public class Binary_Search_Tree {
    private class Node {
        int val;
        Node left;
        Node right;
    }

    private Node root;

    public Binary_Search_Tree(int[] arr) {
        root = CreateTree(arr, 0, arr.length - 1);
    }

    private Node CreateTree(int[] arr, int si, int ei) {
        if (si > ei) return null;

        int mid = (si + ei) / 2;
        Node nn = new Node();

        nn.val = arr[mid];
        nn.left = CreateTree(arr, si, mid - 1);
        nn.right = CreateTree(arr, mid + 1, ei);

        return nn;
    }

    public int max() {
        return max(this.root);
    }

    private int max(Node root) {
        if (root == null) return Integer.MIN_VALUE;

        int right = max(root.right);
        return Math.max(right, root.val);
    }

    public int min() {
        return min(this.root);
    }

    private int min(Node root) {
        if (root == null) return Integer.MAX_VALUE;

        int left = min(root.left);
        return Math.min(left, root.val);
    }

    public boolean search(int item) {
        return search(this.root, item);
    }

    private boolean search(Node node, int item) {
        if (node == null) return false;

        if (node.val == item) return true;
        else if (node.val > item) return search(node.left, item);
        else return search(node.right, item);
    }


}
