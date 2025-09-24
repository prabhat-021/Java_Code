package BinaryTree.Traversal;

import java.util.*;

public class BottomView {
    public static void main(String[] args) {

    }

    public static class Node {
        int val;
        Node left;
        Node right;
    }

    public class Pair {
        Node node;
        int ht;

        public Pair(Node node, int ht) {
            this.node = node;
            this.ht = ht;
        }
    }

    //Function to return a list containing the bottom view of the given .
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        Queue<Pair> qp = new LinkedList<>();

        qp.add(new Pair(root, 0));

        while (!qp.isEmpty()) {
            Pair it = qp.poll();
            Node temp = it.node;
            int ht = it.ht;

            mp.put(ht, temp.val); // Replace value corresponding to that vertical level

            if (temp.left != null) qp.add(new Pair(temp.left, ht - 1));
            if (temp.right != null) qp.add(new Pair(temp.right, ht + 1));
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}
