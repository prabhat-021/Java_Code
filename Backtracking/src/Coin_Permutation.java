import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coin_Permutation {
    public static void main(String[] args) {
        int[] coin = {2, 1, 3, 5};
        int amount = 5;
//        Arrays.sort(coin);
//        Permutation(coin, amount, "");
        List<Integer> ll = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Combination(coin, amount, ll, 0, ans);
        System.out.println(ans);
    }

    public static void Permutation(int[] coin, int amount, String ans) {
        if (amount == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < coin.length; i++) {
            if (amount >= coin[i]) {
                Permutation(coin, amount - coin[i], ans + coin[i] + ',');
            }
        }
    }

    public static void Combination(int[] coin, int amount, List<Integer> ll, int idx, List<List<Integer>> ans) {
        if (amount == 0) {
            ans.add(new ArrayList<>(ll));
            return;
        }

        for (int i = idx; i < coin.length; i++) {
            if (amount >= coin[i]) {
//                amount-=coin[i]
                ll.add(coin[i]);
                Combination(coin, amount - coin[i], ll, i, ans);
                ll.remove(ll.size() - 1);
                //                amount+=coin[i]
            }
        }
    }
}
