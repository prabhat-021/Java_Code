package BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ItrativePostOrder {
    public static void main(String[] args) {

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        if (root == null)
            return postorder;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            postorder.add(root.val);

            if (root.left != null)
                stack.push(root.left);
            if (root.right != null)
                stack.push(root.right);
        }

        Collections.reverse(postorder);
        return postorder;
    }
}
