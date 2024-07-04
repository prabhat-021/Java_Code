package questionsInLecture;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class isGraphBipartite {
    public static void main(String[] args) {

    }

    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        Queue<BipartitePair> qp = new LinkedList<>();
        for (int src = 0; src < graph.length; src++) {
            if (visited.containsKey(src)) continue;
            qp.add(new BipartitePair(src, 0));
            while (!qp.isEmpty()) {
                BipartitePair rv = qp.poll();
                if (visited.containsKey(rv.vtx)) {
                    if (visited.get(rv.vtx) != rv.distance) {
                        return false;
                    } else continue;
                }
                visited.put(rv.vtx, rv.distance);
                for (int nbrs : graph[rv.vtx]) {
                    if (!visited.containsKey(nbrs)) {
                        BipartitePair np = new BipartitePair(nbrs, rv.distance + 1);
                        qp.add(np);
                    }
                }
            }
        }
        return true;
    }

    class BipartitePair {
        int vtx;
        int distance;

        public BipartitePair(int vtx, int distance) {
            this.distance = distance;
            this.vtx = vtx;
        }
    }
}
