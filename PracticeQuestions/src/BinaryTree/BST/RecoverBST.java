package BinaryTree.BST;

import BinaryTree.TreeNode;

public class RecoverBST {
    public static void main(String[] args) {

    }

    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (first != null && last != null) {
            int ch = first.val;
            first.val = last.val;
            last.val = ch;
        } else if (first != null && middle != null) {
            int ch = first.val;
            first.val = middle.val;
            middle.val = ch;
        }
    }

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && (root.val < prev.val)) {
            if (first == null) {
                first = prev;
                middle = root;
            } else last = root;
        }

        prev = root;
        inorder(root.right);
    }
}
