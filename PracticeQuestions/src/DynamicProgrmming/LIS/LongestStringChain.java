package DynamicProgrmming.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public static void main(String[] args) {
        String[] words={"a","b","ba","bca","bda","bdca"};
//        System.out.println(longestStrChain(words));
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Arrays.fill(dp, 1);

        int ans = 1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (check(words[i], words[prev]) && dp[i] < 1 + dp[prev]) {
                    dp[i] = 1 + dp[prev];
                }
            }
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }

        return ans;
    }

    public boolean check(String s, String t) {
        if (s.length() != t.length() + 1)
            return false;

        int first = 0, sec = 0;

        while (first < s.length()) {
            if (sec < t.length() && s.charAt(first) == t.charAt(sec)) {
                first++;
                sec++;
            } else
                first++;
        }

        if (first == s.length() && sec == t.length())
            return true;
        return false;
    }
}
