package BinaryTree.Traversal;

import BinaryTree.Medium.MaximumPathSum;

import javax.swing.event.ListDataListener;
import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {

    }

    public static class Tuple {
        MaximumPathSum.TreeNode node;
        int x;
        int y;

        public Tuple(MaximumPathSum.TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(MaximumPathSum.TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Tuple> qp = new LinkedList<>();
        qp.offer(new Tuple(root, 0, 0));

        while (!qp.isEmpty()) {
            Tuple tuple = qp.poll();
            MaximumPathSum.TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            if (!mp.containsKey(x)) mp.put(x, new TreeMap<>());
            if (!mp.get(x).containsKey(y)) mp.get(x).put(y, new PriorityQueue<>());

            mp.get(x).get(y).offer(node.val);

            if (node.left != null) qp.offer(new Tuple(node.left, x - 1, y + 1));
            if (node.right != null) qp.offer(new Tuple(node.right, x + 1, y + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> tt : mp.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : tt.values()) {
                while (!nodes.isEmpty()) {
                    ans.get(ans.size() - 1).add(nodes.poll());
                }
            }
        }

        return ans;
    }
}
