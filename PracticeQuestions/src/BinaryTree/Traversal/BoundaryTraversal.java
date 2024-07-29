package BinaryTree.Traversal;

import BinaryTree.Medium.MaximumPathSum;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> printBoundary(MaximumPathSum.TreeNode node) {
        List<Integer> ans = new ArrayList<>();

        if (node == null) return ans;
        ans.add(node.val);
        addLeftBoundary(node.left, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);

        return ans;
    }

    void addLeftBoundary(MaximumPathSum.TreeNode node, List<Integer> ans) {
        if (node == null || (node.left == null && node.right == null)) return;
        ans.add(node.val);
        if (node.left != null) addLeftBoundary(node.left, ans);
        else addLeftBoundary(node.right, ans);
    }

    void addLeaves(MaximumPathSum.TreeNode node, List<Integer> ans) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            ans.add(node.val);
            return;
        }
        addLeaves(node.left, ans);
        addLeaves(node.right, ans);
    }

    void addRightBoundary(MaximumPathSum.TreeNode node, List<Integer> ans) {
        if (node == null || (node.left == null && node.right == null)) return;

        if (node.right != null) addRightBoundary(node.right, ans);
        else addRightBoundary(node.left, ans);
//        AFTER COMING BACK
        ans.add(node.val);
    }
}
