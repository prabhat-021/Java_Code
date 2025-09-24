package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthBinaryTree {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public class Pair {
        TreeNode node;
        int ht;

        public Pair(TreeNode node, int ht) {
            this.node = node;
            this.ht = ht;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> qp = new LinkedList<>();
        qp.add(new Pair(root, 0));
        int ans = 0;
        while (!qp.isEmpty()) {
            int size = qp.size();
            int start = 0, end = 0;

            for (int i = 0; i < size; i++) {
                Pair rv = qp.poll();
                int idx = rv.ht;
                TreeNode node = rv.node;

                if (i == 0) start = idx;
                if (i == size - 1) end = idx;

                if (node.left != null) {
                    qp.add(new Pair(node.left, 2 * rv.ht));
                }
                if (node.right != null) {
                    qp.add(new Pair(node.right, 2 * rv.ht + 1));
                }
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
