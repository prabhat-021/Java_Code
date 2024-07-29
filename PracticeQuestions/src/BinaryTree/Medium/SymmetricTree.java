package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if ((root1 == null && root2 == null)) return true;
        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;

        return isSymmetric(root1.left, root2.left) && isSymmetric(root1.right, root2.right);
    }
}
