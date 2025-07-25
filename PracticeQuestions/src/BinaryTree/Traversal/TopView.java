package BinaryTree.Traversal;

import java.util.*;

public class TopView {
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

    public List<Integer> topView(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        HashMap<Integer, Integer> mp = new HashMap<>();
        Queue<Pair> qp = new LinkedList<>();

        qp.add(new Pair(root, 0));

        while (!qp.isEmpty()) {
            Pair it = qp.poll();
            int ht = it.ht;
            Node temp = it.node;

            if (!mp.containsKey(ht)) mp.put(ht, temp.val);

            if (temp.left != null) qp.add(new Pair(temp.left, ht - 1));
            if (temp.right != null) qp.add(new Pair(temp.right, ht + 1));
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

}
