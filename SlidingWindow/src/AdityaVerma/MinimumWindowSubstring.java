package AdityaVerma;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {

    }

    public static String minWindow(String s, String t) {
//         NULL CASE
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

        HashMap<Character, Integer> mp = new HashMap<>();
//        HashMap<Character, Integer> temp = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            if (mp.containsKey(t.charAt(i))) mp.put(t.charAt(i), mp.get(t.charAt(i))+1);
            else mp.put(t.charAt(i), 1);
        }

        int i = 0, j = 0;
        int count = mp.size(), start = 0, min = Integer.MAX_VALUE;
        int temp = min;

        while (j < s.length()) {
            char ch = s.charAt(j);
            if (mp.containsKey(ch)) {
                mp.put(ch, mp.getOrDefault(ch, 0) - 1);
                if (mp.get(ch) == 0) {
                    count--;
                }
            }
            if (count > 0) {
                j++;
                continue;
            } else if (count == 0) {
                temp = min;

                min = Math.min(min, j - i + 1);
                if (temp != min) {
                    start = i;
                }

                while (count == 0) {
                    char ch2 = s.charAt(i);
                    if (mp.containsKey(ch2)) {
                        mp.put(ch2, mp.getOrDefault(ch2, 0) + 1);
                        if (mp.get(ch2) == 1) {
                            count++;
                        }
                    }
                    i++;
                    if (count == 0) {
                        min = Math.min(min, j - i + 1);
                        if (temp != min) start = i;
                    }
                }
                j++;
            }
        }
        if (min == Integer.MAX_VALUE) return "";
        return s.substring(start, start + min);
    }

    public class minimum_window_substring {
        public static void main(String[] args) {
            String s = "timetopractice", t = "toc";


            HashMap<Character, Integer> map = new HashMap<>();
            for (int x = 0; x < t.length(); x++) {
                char c = t.charAt(x);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int i = 0, j = 0;
            int min = Integer.MAX_VALUE;
            int temp = min;
            int count = map.size();
            int start = 0;
            while (j < s.length()) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.getOrDefault(c, 0) - 1);
                    if (map.get(c) == 0) {
                        count--;
                    }
                }
                if (count > 0)
                    j++;
                if (count == 0) {
                    temp = min;

                    min = Math.min(min, j - i + 1);
                    if (temp != min)
                        start = i;

                    while (count == 0) {
                        char c2 = s.charAt(i);
                        if (map.containsKey(c2)) {
                            map.put(c2, map.getOrDefault(c2, 0) + 1);
                            if (map.get(c2) == 1)
                                count++;
                        }
                        i++;
                        if (count == 0) {
                            min = Math.min(min, j - i + 1);
                            if (temp != min)
                                start = i;
                        }
                    }
                    j++;

                }

            }
            if (min == Integer.MAX_VALUE)
                System.out.println("0");                           //1
            System.out.println(s.substring(start, start + min).length());  //2

        }
    }
}
