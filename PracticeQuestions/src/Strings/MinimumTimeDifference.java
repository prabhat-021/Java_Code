package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
    public static void main(String[] args) {
        ArrayList<String> times = new ArrayList<>();

        // Add time strings to the ArrayList
        times.add("00:00");
        times.add("23:59");
        times.add("00:00");
//        System.out.println(findMinDifference(times));
    }

    public int findMinDifference1(List<String> timePoints) {
        int ans = Integer.MAX_VALUE;
        Collections.sort(timePoints, Collections.reverseOrder());

        for (int i = 0; i < timePoints.size(); i++) {
            int hr1 = Integer.parseInt(timePoints.get(i).substring(0, 2));
            int min1 = Integer.parseInt(timePoints.get(i).substring(3, 5));
            if (hr1 == 0 && min1 == 0) hr1 = 24;
            int hr2 = Integer.parseInt(timePoints.get(i + 1).substring(0, 2));
            int min2 = Integer.parseInt(timePoints.get(i + 1).substring(3, 5));
            if (hr2 == 0 && min2 == 0) hr2 = 24;
            hr1 = hr1 * 60 + min1;
            hr2 = hr2 * 60 + min2;
            ans = Math.min(ans, Math.abs(hr2 + hr1));
        }

        return ans;
    }

    private int findMinDifference(List<String> timePoints) {
        int res = Integer.MAX_VALUE;
        int N = timePoints.size();
        int[] c = new int[N];

        for (int i = 0; i < N; i++) {
            String s = timePoints.get(i);
            c[i] = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
        }
        Arrays.sort(c);
        for (int i = 1; i < N; i++) {
            res = Math.min(res, c[i] - c[i - 1]);
        }
        res = Math.min(res, c[0] + (24 * 60 - c[N - 1]));
        return res;
    }
}
