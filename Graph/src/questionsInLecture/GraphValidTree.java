package questionsInLecture;

import java.util.*;

public class GraphValidTree {
    public static void main(String[] args) {

    }

    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            mp.get(a).add(b);
            mp.get(b).add(a);
        }

        return BFT(mp);
    }

    public boolean BFT(HashMap<Integer, List<Integer>> mp) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> qp = new LinkedList<>();
        int count = 0;
        for (int src : mp.keySet()) {
            if (visited.contains(src)) continue;
            count++;
            qp.add(src);
            while (!qp.isEmpty()) {
                int rv = qp.poll();
                if (visited.contains(rv)) return false;
                visited.add(rv);
                for (int nbrs : mp.get(rv)) {
                    if (!visited.contains(nbrs)) qp.add(nbrs);
                }
            }
        }
        return count == 1;
    }
}
