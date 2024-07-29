package questionsInLecture.SpanningTree;

import java.util.*;

public class Kruskal_Algo {
    public static void main(String[] args) {
        Kruskal_Algo ka = new Kruskal_Algo(7);
        ka.addEdge(1, 2, 3);
        ka.addEdge(1, 4, 4);
        ka.addEdge(2, 3, 5);
        ka.addEdge(3, 4, 6);
        ka.addEdge(4, 5, 8);
        ka.addEdge(5, 6, 2);
        ka.addEdge(5, 7, 1);
        ka.addEdge(6, 7, 9);
        ka.Kruskals();
    }

    HashMap<Integer, HashMap<Integer, Integer>> mp;

    public Kruskal_Algo(int v) {
        this.mp = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            mp.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int cost) {
        mp.get(v1).put(v2, cost);
        mp.get(v2).put(v1, cost);


    }



    public void Kruskals() {
        List<KruskalsPair> ll = AllEdges();
        Collections.sort(ll, new Comparator<KruskalsPair>() {
            @Override
            public int compare(KruskalsPair o1, KruskalsPair o2) {
                return o1.cost - o2.cost;
            }
        });

        for (int v : mp.keySet()) {
            CreateSet(v);
        }

        int ans = 0;

        for (KruskalsPair e : ll) {
            int e1 = e.e1;
            int e2 = e.e2;
            int re1 = find(e1);
            int re2 = find(e2);

            if (re1 == re2) {
                continue;
            } else {
                union(e1, e2);
                System.out.println(e);
                ans += e.cost;
            }
        }
        System.out.println(ans);
    }

    class KruskalsPair {
        int e1;
        int e2;
        int cost;

        public KruskalsPair(int e1, int e2, int cost) {
            this.e1 = e1;
            this.e2 = e2;
            this.cost = cost;
        }

        public String toString() {
            return this.e1 + " --> " + this.e2 + " @ " + this.cost;
        }
    }

    public List<KruskalsPair> AllEdges() {
        List<KruskalsPair> ll = new ArrayList<>();
        for (int e1 : mp.keySet()) {
            for (int e2 : mp.get(e1).keySet()) {
                int cost = mp.get(e1).get(e2);
                ll.add(new KruskalsPair(e1, e2, cost));
            }
        }
        return ll;
    }

    class Node {
        int val;
        int rank;
        Node parent;
    }

    private HashMap<Integer, Node> map = new HashMap<>();

    public void CreateSet(int v) {
        Node nn = new Node();
        nn.val = v;
        nn.rank = 0;
        nn.parent = nn;
        map.put(v, nn);
    }

    public int find(int v) {
        Node nn = map.get(v);
        return find(nn).val;
    }

    private Node find(Node nn) {
        if (nn.parent == nn) return nn;
        Node rn = find(nn.parent);
        nn.parent = rn; // Path Compression
        return rn;
    }

    public void union(int v1, int v2) {
        Node n1 = map.get(v1); // 4 node wala
        Node n2 = map.get(v2); // 7 node wla

        Node rn1 = find(n1); // rn1 v1 kare walanode
        Node rn2 = find(n2);  // rn2 v2 ka re wla node

        if (rn1.rank == rn2.rank) {
            rn1.parent = rn2;
            rn2.rank++;
        } else if (rn1.rank > rn2.rank) {
            rn2.parent = rn1;
        } else {
            rn1.parent = rn2;
        }
    }
}
