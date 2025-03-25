package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LexicoCounting {
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        lexcoPrint(0, 13, ans);
    }

    public static void lexcoPrint(int curr, int n, List<Integer> ans) {
        if (curr > n) return;
//        System.out.println(curr);
        if (curr != 0) ans.add(curr);
        int i = 0;
        if (curr == 0) i = 1;
        for (; i <= 9; i++) {
            lexcoPrint(curr * 10 + i, n, ans);
        }
    }
}
