public class sumOfSubsets {
    public static void main(String[] args) {

    }

    static void sumSubset(int[] a, int n, int idx, int sum) {
//      base case
        if (idx >= n) {
            System.out.println(sum);
            return;
        }
//        curr+sum;
        sumSubset(a, n, idx + 1, a[idx] + sum);
//        curr sum only
        sumSubset(a, n, idx + 1, sum);

    }
}
