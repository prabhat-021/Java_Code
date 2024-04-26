package BinarySearch;

public class MinimizeMaxDistanceToGasStation {
    public static void main(String[] args) {

    }

    //    BRUTE FORCE APPORACH (K*N)+ N
    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];

        for (int gasStations = 1; gasStations <= k; gasStations++) {
//            Find the maximum section
            double maxSection = -1;
            int maxInd = -1;
            for (int i = 0; i < n-1; i++) {
                double diff = arr[i + 1] - arr[i];
                double sectionLength = diff / (double) (howMany[i] + 1);
                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            howMany[maxInd]++;
        }

        double ans = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength = diff / (double) (howMany[i] + 1);
            ans = Math.max(ans, sectionLength);
        }
        return ans;
    }

//
}
