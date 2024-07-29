package DynamicProgrmming.D_2;

import java.util.ArrayList;
import java.util.List;

public class NinjaTraining {
    public static void main(String[] args) {

    }

    public static int fn(int day, int last, List<List<Integer>> points, int[][] dp) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, points.get(0).get(i));
                }
            }
            return max;
        }

        if (dp[day][last] != -1) return dp[day][last];

        int max = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points.get(day).get(task) + fn(day - 1, last, points, dp);
                max = Math.max(max, point);
            }
        }
        return dp[day][last] = max;
    }

    public static int fn_BU(List<List<Integer>> points) {
        int[][] dp = new int[points.size()][4];

        dp[0][0] = Math.max(points.get(0).get(1), points.get(0).get(2));
        dp[0][1] = Math.max(points.get(0).get(0), points.get(0).get(2));
        dp[0][2] = Math.max(points.get(0).get(1), points.get(0).get(0));
        dp[0][3] = Math.max(points.get(0).get(1), Math.max(points.get(0).get(2), points.get(0).get(0)));


        for (int day = 1; day < points.size(); day++) {
            for (int last = 0; last < 3; last++) {
                for (int task = 0; task < 3; task++) {
                    dp[day][last] = 0;
                    if (task != last) {
                        int point = points.get(day).get(task) + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[points.size() - 1][3];
    }
}
