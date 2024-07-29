package BinaryTree.Traversal;

import BinaryTree.Medium.MaximumPathSum;

import java.util.*;

public class RightView {
    public static void main(String[] args) {

    }

    public class Pair {
        MaximumPathSum.TreeNode node;
        int level;

        public Pair(MaximumPathSum.TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(MaximumPathSum.TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        if (root == null) return ans;

        Queue<Pair> qp = new LinkedList<>();
        qp.add(new Pair(root, 0));
        while (!qp.isEmpty()) {
            Pair it = qp.poll();
            MaximumPathSum.TreeNode node = it.node;
            int level = it.level;

            if (!mp.containsKey(level)) mp.put(level, node.val);

            if (node.right != null) qp.add(new Pair(node.right, level + 1));
            if (node.left != null) qp.add(new Pair(node.left, level + 1));
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    private void recursionRight(MaximumPathSum.TreeNode root, int level, List<Integer> res) {
        // Check if the current node is null
        if (root == null) {
            return;
        }

        // Check if the size of the result list
        // is equal to the current level
        if (res.size() == level) {
            // If equal, add the value of the
            // current node to the result list
            res.add(root.val);

            // Recursively call the function for the
            // right child with an increased level
            recursionRight(root.right, level + 1, res);

            // Recursively call the function for the
            // left child with an increased level
            recursionRight(root.left, level + 1, res);
        }
    }
}
