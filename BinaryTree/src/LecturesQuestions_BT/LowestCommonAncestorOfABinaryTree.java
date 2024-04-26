package LecturesQuestions_BT;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {

    }

    public class Node {
        int val;
        Node left;
        Node right;
    }

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        return CommonAncestor(root,p,q);
    }

    public Node CommonAncestor(Node root, Node p, Node q) {
        if (root == null) return null;
        if (root == p || root == p) return root;

        Node left = CommonAncestor(root.left, p, q);
        Node right = CommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        else if (left == null) return right;
        else return left;
    }
}
