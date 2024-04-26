package Arrays;

public class LastMomentBeforeAllAntFallOutPlank {
    public static void main(String[] args) {

    }

    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int i = 0, j = 0; i < left.length + right.length - 1; i++) {
            if (i < left.length) ans = Math.max(ans, left[i]);
            else ans = Math.max(ans, right[j++]);
        }
        return ans;
    }
}
