public class Knapsack01 {
    public static void main(String[] args) {

    }

    public static int maximumValue(int[] wt, int[] val, int cap, int i) {
        if (i == wt.length || cap == 0) return 0;

        int inc = 0;
        int exc = 0;
        if (cap >= wt[i]) {
            inc = val[i] + maximumValue(wt, val, cap - wt[i], i + 1);
        }

        exc = maximumValue(wt, val, cap, i + 1);

        return Math.max(inc, exc);
    }

}
