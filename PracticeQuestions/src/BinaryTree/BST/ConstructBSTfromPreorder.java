package BinaryTree.BST;

import BinaryTree.TreeNode;

public class ConstructBSTfromPreorder {
    public static void main(String[] args) {

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode bstFromPreorder(int[] preorder, int bound, int[] idx) {
        if (idx[0] == preorder.length || preorder[idx[0]] > bound) return null;
        TreeNode root = new TreeNode(preorder[idx[0]++]);
        root.left = bstFromPreorder(preorder, root.val, idx);
        root.right = bstFromPreorder(preorder, bound, idx);
        return root;
    }
}
