public class XORqureries {
    public static void main(String[] args) {

    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j < queries[i][1]; j++) {
                ans[i] ^= arr[j];
            }
        }
        return ans;
    }
}
