package BinaryTree.BST;

import BinaryTree.Medium.MaximumPathSum;

public class InsertInBST {
    public static void main(String[] args) {

    }

    public MaximumPathSum.TreeNode insertIntoBST(MaximumPathSum.TreeNode root, int val) {
        return insert(root, val);
    }

    public MaximumPathSum.TreeNode insert(MaximumPathSum.TreeNode root, int val) {
        if (root == null) return new MaximumPathSum.TreeNode(val);

        if (root.val < val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }
}
