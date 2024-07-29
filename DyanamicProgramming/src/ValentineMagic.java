import java.util.Arrays;

public class ValentineMagic {
    public static void main(String[] args) {
        int[] boys = {2, 11, 3};
        int girls[] = {5, 7, 3, 2};
        Arrays.sort(boys);
        Arrays.sort(girls);
        System.out.println(minDiff(boys, girls, 0, 0));
    }

    public static int minDiff(int[] boys, int[] girls, int i, int j) {
        if (i == boys.length) return 0;
        if (j == girls.length) return 100000;

        int sel = Math.abs(boys[i] - girls[j]) + minDiff(boys, girls, i + 1, j + 1);
        int rej = minDiff(boys, girls, i, j + 1);

        return Math.min(sel, rej);
    }
}
