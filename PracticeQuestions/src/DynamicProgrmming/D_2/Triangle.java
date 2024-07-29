package DynamicProgrmming.D_2;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        triangle.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        triangle.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        triangle.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list4);

        // Call the minimumPathSum function and print the result
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Calculate the two possible paths: moving down or moving diagonally
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];

                // Store the minimum of the two paths in dp
                dp[i][j] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    }
}
