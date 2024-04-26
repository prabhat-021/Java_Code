package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElement {
    public static void main(String[] args) {

    }

    public static class Pair implements Comparable<Pair> {
        int val;
        int gap;

        Pair() {
        }

        Pair(int val, int gap) {
            this.gap = gap;
            this.val = val;
        }

        public int compareTo(Pair o) {
            if (this.gap == o.gap) {
                return this.val - o.val;
            } else {
                return this.gap - o.gap;
            }
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < k) {
                pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
            } else {
                if (pq.peek().gap > Math.abs(arr[i] - x)) {
                    pq.remove();
                    pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
                }
            }
        }
        while (!pq.isEmpty()) {
            ans.add(pq.remove().val);
        }
        Collections.sort(ans);

        return ans;
    }
}
