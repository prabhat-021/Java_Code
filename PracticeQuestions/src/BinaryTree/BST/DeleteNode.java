package BinaryTree.BST;

import BinaryTree.Medium.MaximumPathSum;

public class DeleteNode {
    public static void main(String[] args) {

    }

    public MaximumPathSum.TreeNode deleteNode(MaximumPathSum.TreeNode root, int key) {
        return delete(root, key);
    }

    public MaximumPathSum.TreeNode delete(MaximumPathSum.TreeNode root, int key) {
        if (root == null) return null;

        if (root.val < key) {
            root.right = delete(root.right, key);
        } else if (root.val > key) {
            root.left = delete(root.left, key);
        } else {
//            0 or 1 child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) return root.left;
//            2 child
            else {
                int max = max(root.left);
                root.left=delete(root.left, max);
                root.val=max;
            }
        }

        return root;
    }

    public int max(MaximumPathSum.TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;

        int right = max(node.right);
        return Math.max(node.val, right);
    }
}
