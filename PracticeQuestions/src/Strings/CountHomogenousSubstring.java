package Strings;

public class CountHomogenousSubstring {
    public static void main(String[] args) {

    }

    public static int countHomogenous(String s) {
        int ans = 0, MOD = 1000000007, left = 0, right = 0, n = s.length();
        while (right < n) {
            while (right < n && s.charAt(right) == s.charAt(left)) right++;
            long size = right - left;
            ans += (size * (size + 1) * 2) % MOD;
            left = right;
        }
        return (int) ans;
    }

    public int numSub(String s) {
        int ans = 0, MOD = 1000000007, left = 0, right = 0, n = s.length();
        while (left < n && s.charAt(left)!=1) {
//            while (right < n && s.charAt(right)==1) right++;
//            long size = right - left;
//            ans += (size * (size + 1) * 2) % MOD;
//            left = right;
        }
        return (int) ans;
    }
}
