package questionsInLecture.SpanningTree;

import java.util.*;

public class Prism_Algo {
    public static void main(String[] args) {

    }

    private HashMap<Integer, HashMap<Integer, Integer>> map;

    public Prism_Algo(int v) { // Prims_Algo
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    public int Prims() {
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<PrimsPair> pq = new PriorityQueue<>(new Comparator<PrimsPair>() {
            @Override
            public int compare(PrimsPair o1, PrimsPair o2) {
                return o1.cost - o2.cost;
            }
        });
        pq.add(new PrimsPair(3, 3, 0));

        int sum = 0;
        while (!pq.isEmpty()) {
            PrimsPair rv = pq.poll();
            if (visited.contains(rv.vtx)) continue;

            visited.add(rv.vtx);
            System.out.println(rv);
            sum += rv.cost;
            for (int nbrs : map.get(rv.vtx).keySet()) {
                if (!visited.contains(nbrs)) {
                    int cost = map.get(rv.vtx).get(nbrs);
                    pq.add(new PrimsPair(nbrs, rv.vtx, cost));
                }
            }
        }

        return sum;
    }

    class PrimsPair {
        int vtx;
        int acq;
        int cost;

        public PrimsPair(int vtx, int acq, int cost) {
            this.vtx = vtx;
            this.acq = acq;
            this.cost = cost;
        }

    }
}
