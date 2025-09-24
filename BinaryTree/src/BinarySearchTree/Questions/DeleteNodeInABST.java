package BinarySearchTree.Questions;

public class DeleteNodeInABST {
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

    public Node deleteNode(Node root, int key) {
        return delete(root, key);
    }

    public Node delete(Node root, int key) {
        if (root == null) return null;

        if (root.val < key) {
            root.right = delete(root.right, key);
        } else if (root.val > key) {
            root.left = delete(root.left, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                int max = max(root.left);
                root.left = delete(root.left, max);
                root.val = max;
            }
        }
        return root;
    }

    private int max(Node node) {
        if (node == null) return Integer.MIN_VALUE;
        int left = max(node.left);
        int right = max(node.right);
        return Math.max(node.val, Math.max(left, right));
    }
}
