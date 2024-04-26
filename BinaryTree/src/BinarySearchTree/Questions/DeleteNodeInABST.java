package BinarySearchTree.Questions;

import basic.BinaryTree1;

public class DeleteNodeInABST {
    public static void main(String[] args) {

    }

    public InsertIntoABinarySearchTree.Node deleteNode(InsertIntoABinarySearchTree.Node root, int key) {
        return delete(root, key);
    }

    public InsertIntoABinarySearchTree.Node delete(InsertIntoABinarySearchTree.Node root, int key) {
        if (root == null) return null;

        if (root.val < key) {
            root.right = delete(root.right, key);
        } else if (root.val > key) {
            root.left = delete(root.left, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                int max = max(root.left);
                root.left = delete(root.left, max);
                root.val = max;
            }
        }
        return root;
    }

    private int max(InsertIntoABinarySearchTree.Node node) {
        if (node == null) return Integer.MIN_VALUE;
        int left = max(node.left);
        int right = max(node.right);
        return Math.max(node.val, Math.max(left, right));
    }
}
