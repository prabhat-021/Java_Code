package Strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {

    }

    public String frequencySort(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.count-o2.count;
            }
        });
        HashMap<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : mp.keySet()) {
            pq.add(new Pair(ch, mp.get(ch)));
        }

        String ans = "";
        while (!pq.isEmpty()) {
            Pair pp = pq.poll();
            for (int i = 0; i < pp.count; i++) {
                ans += pp.ch;
            }
        }

        return ans;
    }

    public class Pair {
        char ch;
        int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

}
