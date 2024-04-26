package LecturesQuestions_BT;

public class BalancedBinaryTree {
    public static void main(String[] args) {

    }

    public class Node {
        int val;
        Node left;
        Node right;
    }

    public boolean isBalanced(Node root) {
        return isBal(root).isBal;
    }

    public class BalancePair {
        boolean isBal = true;
        int hight = -1;
    }

    public BalancePair isBal(Node root) {
        if (root == null) return new BalancePair();

        BalancePair lbp = isBal(root.left);
        BalancePair rbp = isBal(root.right);

        BalancePair sbp = new BalancePair();
        sbp.hight = Math.max(lbp.hight, rbp.hight) + 1;
        boolean sb = Math.abs(lbp.hight - rbp.hight) <= 1;
        sbp.isBal = lbp.isBal && rbp.isBal && sb;

        return sbp;
    }
}
