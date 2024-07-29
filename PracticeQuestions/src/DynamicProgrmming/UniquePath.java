package DynamicProgrmming;

import java.util.HashSet;

public class UniquePath {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        HashSet<String> hs = new HashSet<>();
        findPath("", 0, 0, hs, m - 1, n - 1);
        return hs.size();
    }

    private void findPath(String ans, int x, int y, HashSet<String> hs, int m, int n) {
        if (x > m || y > n) return;

        if (x == m && y == n) {
            hs.add(ans);
        }

        findPath(ans + x + y, x + 1, y, hs, m, n);
        findPath(ans + x + y, x, y + 1, hs, m, n);
    }
}
