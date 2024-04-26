package basic;

import java.util.*;

public class BinaryTree1 {

    private static class Node {
        int val;
        Node left;
        Node right;
    }

    Scanner sc = new Scanner(System.in);
    private Node root;

    public BinaryTree1() {
        root = CreateTree();
    }

    private Node CreateTree() {
//        return null;
        int item = sc.nextInt();
        Node nn = new Node();
        nn.val = item;
        boolean hlc = sc.nextBoolean();
        if (hlc) {
            nn.left = CreateTree();
        }
        boolean hrc = sc.nextBoolean();
        if (hrc) {
            nn.right = CreateTree();
        }
        return nn;
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

    public boolean find(int item) {
        return find(this.root, item);
    }

    private boolean find(Node node, int item) {
        if (node == null) return false;
        if (node.val == item) return true;
        boolean left = find(node.left, item);
        boolean right = find(node.right, item);
        return left || right;
    }

    public int max() {
        return max(this.root);
    }

    private int max(Node node) {
        if (node == null) return Integer.MIN_VALUE;
        int left = max(node.left);
        int right = max(node.right);
        return Math.max(node.val, Math.max(left, right));
    }

    public int min() {
        return min(this.root);
    }

    private int min(Node node) {
        if (node == null) return Integer.MIN_VALUE;
        int left = min(node.left);
        int right = min(node.right);
        return Math.min(node.val, Math.min(left, right));
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

    public void PreOrder() {
        PreOrder(this.root);
        System.out.println();
    }

    private void PreOrder(Node node) {
        if (node == null) return;
        System.out.println(node.val + " ");
        PreOrder(node.left);
        PreOrder(node.right);
    }

    public void PostOrder() {
        PreOrder(this.root);
        System.out.println();
    }

    private void PostOrder(Node node) {
        if (node == null) return;
        PreOrder(node.left);
        PreOrder(node.right);
        System.out.println(node.val + " ");
    }

    public void inOrder() {
        List<Integer> ll = new ArrayList<>();
        inOrder(this.root, ll);
        System.out.println();
    }


    private List<Integer> inOrder(Node node, List<Integer> list) {
        if (node == null) return new ArrayList<>();
        inOrder(node.left, list);
//        System.out.println(node.val + " ");
        list.add(node.val);
        inOrder(node.right, list);
        return list;
    }

    public List<List<Integer>> levelOrder(Node root) {
        if(root==null) return new ArrayList<>();

        Queue<Node> qp = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        qp.add(root);
        while (!qp.isEmpty()) {
            Node rm = qp.poll(); // remove first
            List<Integer> ll = new ArrayList<>();
            if (rm.left != null) {
                ll.add(rm.left.val);
                qp.add(rm.left);
            }
            if (rm.right != null) {
                ll.add(rm.right.val);
                qp.add(rm.right);
            }
            if(ll.size()!=0)
                ans.add(ll);
        }
//        System.out.println();
        return ans;
    }
}
