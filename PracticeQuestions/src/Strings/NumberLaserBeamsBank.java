package Strings;

import java.util.ArrayList;
import java.util.List;

public class NumberLaserBeamsBank {
    public static void main(String[] args) {
        String[] blank = {"011001", "000000", "010100", "001000" };
        System.out.println(numberOfBeams(blank));
    }

    public static int numberOfBeams(String[] bank) {
        List<Integer> ans = new ArrayList<>();
        int ans1 = 0;
        for (int i = 0; i < bank.length; i++) {
            int count = count1(bank[i]);
            if (count != 0) ans.add(count);
        }
        int i = 0;
        if (ans.size() > 1) {
            while (i < ans.size() - 1) {
                ans1 += ans.get(i) * ans.get(i + 1);
            }
        }
        return ans1;
    }

    private static int count1(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) - '0' == 1) count++;
        }
        return count;
    }
}
