package BinaryTree.Traversal;

import BinaryTree.TreeNode;

import java.util.*;

public class BottomView {
    public static void main(String[] args) {

    }

    public class Pair {
        TreeNode node;
        int ht;

        public Pair(TreeNode node, int ht) {
            this.node = node;
            this.ht = ht;
        }
    }

    //Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        Queue<Pair> qp = new LinkedList<>();

        qp.add(new Pair(root, 0));

        while (!qp.isEmpty()) {
            Pair it = qp.poll();
            int ht = it.ht;
            TreeNode temp = it.node;

            mp.put(ht, temp.val);
            // if (!mp.containsKey(ht)) {
            //     mp.put(ht, temp.data);
            // } else {
            //     mp.remove(ht);
            //     mp.put(ht, temp.data);
            // }

            if (temp.left != null) qp.add(new Pair(temp.left, ht - 1));
            if (temp.right != null) qp.add(new Pair(temp.right, ht + 1));
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}
