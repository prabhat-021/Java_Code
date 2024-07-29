package Heap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class HandOfStraights {
    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println(isNStraightHand(hand, 3));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(hand[i]);
        }

        while (!pq.isEmpty()) {
            int pre = pq.poll();
            for (int i = 1; i < groupSize; i++) {
                if (pq.remove(pre + 1)) continue;
                else return false;
            }
        }

        return true;
    }
}
