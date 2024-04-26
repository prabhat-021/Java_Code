package Greedy;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {

    }

    public int findContentChildren(int[] g, int[] s) {
        int ans = 0, i = 0, j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                ans++;
                i++;
                j++;
            }else {
                j++;
            }
        }
        return ans;
    }
}
