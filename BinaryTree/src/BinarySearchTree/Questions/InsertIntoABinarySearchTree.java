package BinarySearchTree.Questions;

public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {

    }

    public class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node insertIntoBST(Node root, int val) {
        return insert(root, val);
    }

    public Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (root.val < val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }
}
