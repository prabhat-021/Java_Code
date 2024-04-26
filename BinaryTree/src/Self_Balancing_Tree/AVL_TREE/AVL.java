package Self_Balancing_Tree.AVL_TREE;

//import BinarySearchTree.Binary_Search_Tree;

public class AVL {
    public static void main(String[] args) {

    }

    public class Node {
        private int val;
        private Node left;
        private Node right;
        private int height;

        public Node(int val) {
            this.val = val;
        }

        public int getValue() {
            return val;
        }
    }

    private Node root;

    public AVL() {

    }

    public void insert(int val) {
        root = insert(val, root);
    }

    private Node insert(int val, Node node) {
        if (node == null) {
            node = new Node(val);
            return node;
        } else if (val < node.val) {
            node.left = insert(val, node.left);
        } else {
            node.right = insert(val, node.right);
        }

        node.height = Math.max(hight(node.left), hight(node.right)) + 1;

        return rotate(node);
    }

    private Node rotate(Node node) {
        if (hight(node.left) - hight(node.right) > 1) {
//            left heavy
            if (hight(node.left.left) - hight(node.left.right) > 0) {
//                left-left case
                return rightRotate(node);
            } else {
//                left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (hight(node.left) - hight(node.right) < 1) {
//            right heavy
            if (hight(node.right.left) - hight(node.right.right) < 0) {
//                right-right case
                return leftRotate(node);
            } else {
//                right-left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node parent) {
        Node child = parent.left;
        Node test = child.right;

        child.right = parent;
        parent.left = test;

        parent.height = Math.max(hight(parent.left), hight(parent.right)) + 1;
        child.height = Math.max(hight(child.left), hight(child.right)) + 1;

        return child;
    }

    private Node leftRotate(Node child) {
        Node parent = child.right;
        Node test = parent.left;

        parent.left = child;
        child.right = test;

        parent.height = Math.max(hight(parent.left), hight(parent.right)) + 1;
        child.height = Math.max(hight(child.left), hight(child.right)) + 1;

        return parent;
    }

    public int max() {
        return max(this.root);
    }

    private int max(Node root) {
        if (root == null) return Integer.MIN_VALUE;

        int right = max(root.right);
        return Math.max(right, root.val);
    }

    public int min() {
        return min(this.root);
    }

    private int min(Node root) {
        if (root == null) return Integer.MAX_VALUE;

        int left = min(root.left);
        return Math.min(left, root.val);
    }

    public boolean search(int item) {
        return search(this.root, item);
    }

    private boolean search(Node node, int item) {
        if (node == null) return false;

        if (node.val == item) return true;
        else if (node.val > item) return search(node.left, item);
        else return search(node.right, item);
    }

    public int hight() {
        return hight(this.root);
    }

    private int hight(Node node) {
        if (node == null) return -1;
        int left = hight(node.left);
        int right = hight(node.right);
        return Math.max(left, right) + 1;
    }

    public void dispaly() {
        display(root);
    }

    private void display(Node node) {
        if (node == null) return;
        String s = "";
        s = "<--" + node.val + "-->";
        if (node.left != null) {
            s = node.left.val + s;
        } else {
            s = "." + s;
        }

        if (node.right != null) {
            s = s + node.right.val;
        } else {
            s = s + ".";
        }
        System.out.println(s);
        display(node.left);
        display(node.right);
    }

//    TIME COMPLEXITY
//    LOG(N)+O(1) FOR ROTATION
}
//
// ALGORITHM
// STEP1: Insert normally node N
// Step 2: start from node N & find the node that makes the tree unballenced , bottom up
//Step 3: using  one of the 4 rules rotate ;


// Rules
// 1. left-left case
// 2. left right case --> first left rotate then right ;
//
// 3. right-right case
// 4. right left case --> first right rotate then left ;
//