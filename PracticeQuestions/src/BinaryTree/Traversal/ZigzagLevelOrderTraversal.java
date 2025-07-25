package BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }


    public static class Node {
        int val;
        Node left;
        Node right;
    }

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<Node> qp = new LinkedList<>();
        qp.add(root);
        boolean LtoR = true;

        while (!qp.isEmpty()) {
            int size = qp.size();
            List<Integer> ll = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                Node node = qp.poll();

                if (LtoR) {
                    ll.add(node.val);
                } else {
                    ll.add(0, node.val); // Adds to the beginning for reverse order
                }

                if (node.left != null) qp.add(node.left);
                if (node.right != null) qp.add(node.right);
            }
            LtoR = !LtoR;
            ans.add(ll);
        }

        return ans;
    }
}
