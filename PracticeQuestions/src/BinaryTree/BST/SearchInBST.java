package BinaryTree.BST;

import BinaryTree.Medium.MaximumPathSum;

public class SearchInBST {
    public static void main(String[] args) {

    }

    public MaximumPathSum.TreeNode searchBST(MaximumPathSum.TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        return (root.val > val) ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
