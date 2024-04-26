package BinarySearchTree.Questions;

public class ValidateBinarySearchTree {
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
    }

    public boolean isValidBST(Node root) {
        return validBst(root).isBst;
    }

    public bstPair validBst(Node root) {
        if (root == null) return new bstPair();

        bstPair lbstp = validBst(root.left);
        bstPair rbstp = validBst(root.right);
        bstPair sbstp = new bstPair();

        sbstp.max = Math.max(root.val, Math.max(lbstp.max, rbstp.max));
        sbstp.min = Math.min(root.val, Math.min(lbstp.min, rbstp.min));
        sbstp.isBst = lbstp.isBst && rbstp.isBst && root.val > lbstp.max && root.val < rbstp.min;

        return sbstp;
    }
}
