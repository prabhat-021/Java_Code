import java.util.*;

public class Graph {
    public static void main(String[] args) {
    }

    private final HashMap<Integer, HashMap<Integer, Integer>> map;

    public Graph(int v) {
        map = new HashMap<>();
        for (int i = 0; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    public boolean ContainsEdge(int v1, int v2) {
        return map.get(v1).containsKey(v2);
    }

    public int noOfNode() {
        int sum = 0;
        for (int key : map.keySet()) {
            sum += map.get(key).size();
        }
        return sum / 2;
    }

    public void RemoveEdge(int v1, int v2) {
        if (ContainsEdge(v1, v2)) {
            map.get(v1).remove(v2);
            map.get(v2).remove(v1);
        }
    }

    public void RemoveVertex(int v1) {
        for (int nbrs : map.get(v1).keySet()) {
            map.get(nbrs).remove(v1);
        }
        map.remove(v1);
    }

    public void dispaly() {
        for (int key : map.keySet()) {
            System.out.println(key + "-->" + map.get(key));
        }
    }

    public boolean hasPath(int src, int dest, HashSet<Integer> visited) {
        if (src == dest) {
            return true;
        }

        visited.add(src);
        for (int nbrs : map.get(src).keySet()) {
            if (!visited.contains(nbrs)) {
                boolean ans = hasPath(src, dest, visited);
                if (ans) {
                    return ans;
                }
            }
        }
        visited.remove(src);

        return false;
    }

    public void printAllPath(int src, int dest, HashSet<Integer> visited, String ans) {
        if (src == dest) {
            System.out.println(ans);
            return;
        }

        visited.add(src);
        for (int nbrs : map.get(src).keySet()) {
            if (!visited.contains(nbrs)) {
                printAllPath(src, dest, visited, ans + src);
            }
        }
        visited.remove(src);
    }

    public boolean BFS(int src, int dest) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> qp = new LinkedList<>();
        qp.add(src);
        while (!qp.isEmpty()) {
//            1. Remove
            int rv = qp.poll();
//            2. Ignore if already visited
            if (visited.contains(rv)) continue;
//            3. marked visited
            visited.add(rv);
//            4. self work
            if (src == dest) {
                return true;
            }
//            5. add nbrs unvisited
            for (int nbrs : map.get(rv).keySet()) {
                if (!visited.contains(nbrs)) {
                    qp.add(nbrs);
                }
            }
        }
        return false;
    }

    public boolean DFS(int src, int dest) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        st.push(src);
        while (!st.isEmpty()) {
//            1. Remove
            int rv = st.pop();
//            2. Ignore if already visited
            if (visited.contains(rv)) continue;
//            3. marked visited
            visited.add(rv);
//            4. self work
            if (src == dest) {
                return true;
            }
//            5. add nbrs unvisited
            for (int nbrs : map.get(rv).keySet()) {
                if (!visited.contains(nbrs)) {
                    st.add(nbrs);
                }
            }
        }
        return false;
    }

    public void BFT() {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> qp = new LinkedList<>();

        for (int src : map.keySet()) {
            if (visited.contains(src)) continue;
            qp.add(src);
            while (!qp.isEmpty()) {
//                1. REMOVE
                int rv = qp.poll();
//                2.Ignore
                if (visited.contains(rv)) continue;
//                3.marked visited
                visited.add(rv);
//                4.self work
                System.out.println(rv + " ");
//                5.add nbrs unvisited
                for (int nbrs : map.get(rv).keySet()) {
                    if (!visited.contains(nbrs)) {
                        qp.add(nbrs);
                    }
                }
            }
        }
        System.out.println();
    }

    public void DFT() {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        for (int src : map.keySet()) {
            if(visited.contains(src))continue;
            st.push(src);
            while (!st.isEmpty()) {
//            1. Remove
                int rv = st.pop();
//            2. Ignore if already visited
                if (visited.contains(rv)) continue;
//            3. marked visited
                visited.add(rv);
//            4. self work
                System.out.println(rv + " ");
//            5. add nbrs unvisited
                for (int nbrs : map.get(rv).keySet()) {
                    if (!visited.contains(nbrs)) {
                        st.add(nbrs);
                    }
                }
            }
        }

        System.out.println();
    }



}
