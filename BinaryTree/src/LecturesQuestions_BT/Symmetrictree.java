package LecturesQuestions_BT;

public class Symmetrictree {
    public static void main(String[] args) {

    }

    public boolean isSymetric(Node node) {
        return Symmetric(node.left, node.right);
    }

    private static class Node {
        int val;
        Node left;
        Node right;
    }

    public boolean Symmetric(Node node1, Node node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        boolean left = Symmetric(node1.left, node2.right);
        boolean right = Symmetric(node1.right, node2.left);
        return left && right;
    }

}
