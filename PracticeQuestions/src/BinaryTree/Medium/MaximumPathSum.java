package BinaryTree.Medium;

public class MaximumPathSum {
    public static void main(String[] args) {

    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        maxPathSum(root, ans);
        return ans[0];
    }

    private int maxPathSum(TreeNode node, int[] ans) {
        if (node == null) return 0;

        int leftSum = Math.max(0, maxPathSum(node.left, ans));
        int rightSum = Math.max(0, maxPathSum(node.right, ans));

        ans[0] = Math.max(ans[0], leftSum + rightSum + node.val);

        return node.val + Math.max(leftSum, rightSum);
    }

}
