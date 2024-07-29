package BinaryTree.BST;

import BinaryTree.Medium.MaximumPathSum;

public class ValidBST {
    public static void main(String[] args) {

    }

    public boolean isValidBST(MaximumPathSum.TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(MaximumPathSum.TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val >= max || root.val <= min) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
