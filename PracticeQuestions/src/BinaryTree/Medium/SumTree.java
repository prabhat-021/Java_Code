package BinaryTree.Medium;

public class SumTree {
    public static void main(String[] args) {

    }


    public static class Node {
        int val;
        Node left;
        Node right;
    }

    public static class SumPair {
        boolean curr = true;
        int sum = 0;

        SumPair(int val) {
            sum = val;
        }
    }

    public boolean isSumTree(Node root) {
        return isSum(root).curr;
    }

    public SumPair isSum(Node root) {
        if (root == null) return new SumPair(0);
        if (root.right == null && root.left == null) return new SumPair(root.val);

        SumPair left = isSum(root.left);
        SumPair right = isSum(root.right);
        SumPair ans = new SumPair(0);
        if (left.sum + right.sum != root.val) ans.curr = false;
        if (ans.curr) ans.sum = 2 * root.val;
        return ans;
    }

}
