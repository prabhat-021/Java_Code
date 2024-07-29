package questionsInLecture;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class SingleSourceShortestPath {
    public static void main(String[] args) {
        SingleSourceShortestPath dj = new SingleSourceShortestPath(7);
        dj.AddEdges(1, 4, 2);
        dj.AddEdges(1, 2, 4);
        dj.AddEdges(2, 3, 5);
        dj.AddEdges(3, 4, 1);
        dj.AddEdges(4, 5, 6);
        dj.AddEdges(5, 6, 11);
        dj.AddEdges(7, 5, 3);
        dj.AddEdges(6, 7, 3);
        dj.Dijkstra(1);
    }

    private HashMap<Integer, HashMap<Integer, Integer>> map;

    public SingleSourceShortestPath(int v) { // Dijkstra_Algo
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void AddEdges(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    public void Dijkstra(int src) {
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<DijkstraPair> pq = new PriorityQueue<>(new Comparator<DijkstraPair>() {
            @Override
            public int compare(DijkstraPair o1, DijkstraPair o2) {
                return o1.cost - o2.cost;
            }
        });
        pq.add(new DijkstraPair(src, "" + src, 0));

        while (!pq.isEmpty()) {
            DijkstraPair rp = pq.poll();
            if (visited.contains(rp.vtx)) continue;

            visited.add(rp.vtx);
            System.out.println(rp);

            for (int nbrs : map.get(rp.vtx).keySet()) {
                if (!visited.contains(nbrs)) {
                    int cost = rp.cost + map.get(rp.vtx).get(nbrs);
                    DijkstraPair newPair = new DijkstraPair(nbrs, rp.acq + nbrs, cost);
                    pq.add(newPair);
                }
            }
        }

    }

    class DijkstraPair {
        int vtx;
        String acq;
        int cost;

        public DijkstraPair(int vtx, String acq, int cost) {
            this.vtx = vtx;
            this.acq = acq;
            this.cost = cost;
        }

        public String toString() {
            return this.vtx + " " + this.acq + " @ " + this.cost;
        }
    }
}
