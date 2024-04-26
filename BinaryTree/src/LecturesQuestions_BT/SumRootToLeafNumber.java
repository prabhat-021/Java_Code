package LecturesQuestions_BT;

public class SumRootToLeafNumber {
    public static void main(String[] args) {

    }

    public class Node {
        int val;
        Node left;
        Node right;
    }

    public int sumNumber(Node node) {
        return sum(node, 0);
    }

    public int sum(Node node, int num) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return num * 10 + node.val;
        int left = sum(node.left, num * 10 + node.val);
        int right = sum(node.right, num * 10 + node.val);
        return left + right;
    }

}
