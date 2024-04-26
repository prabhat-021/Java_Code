package LecturesQuestions_BT;

public class PathSum {
    public static void main(String[] args) {

    }

    public class Node {
        int val;
        Node left;
        Node right;
    }

    public boolean hasPathSum(Node node, int target) {
        if (node == null) return false;

        if (node.left == null && node.right == null) return target - node.val == 0;

        boolean left = hasPathSum(node.left, target - node.val);

        boolean right = hasPathSum(node.right, target - node.val);

        return left || right;
    }
}
