package BinarySearchTree.Questions;

public class LargestBSTSubTree {
    public static void main(String[] args) {

    }

    public class Node {
        int val;
        Node left;
        Node right;
    }

    public class bstPair {
        boolean isBst = true;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        int size = 0;
        int sum = 0;
        int ans = 0;
    }

    public int largestBSTSubTree(Node root) {
        return validBst(root).size;
    }

    public int maxSumBST(Node root) {
        return validBst(root).ans;
    }

    public bstPair validBst(Node root) {
        if (root == null) return new bstPair();

        bstPair lbstp = validBst(root.left);
        bstPair rbstp = validBst(root.right);
        bstPair sbstp = new bstPair();

        sbstp.max = Math.max(root.val, Math.max(lbstp.max, rbstp.max));
        sbstp.min = Math.min(root.val, Math.min(lbstp.min, rbstp.min));
        sbstp.isBst = lbstp.isBst && rbstp.isBst && root.val > lbstp.max && root.val < rbstp.min;
        sbstp.sum = lbstp.sum + rbstp.sum + root.val;

        if (sbstp.isBst) {
            sbstp.size = lbstp.size + rbstp.size;
            sbstp.ans = Math.max(sbstp.sum, Math.max(lbstp.ans, rbstp.ans));
        } else {
            sbstp.size = Math.max(lbstp.size, rbstp.size);
            sbstp.ans = Math.max(lbstp.ans, rbstp.ans);
        }

        return sbstp;
    }

}
