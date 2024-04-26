import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class sortSquareOfArray {

    static int[] sortSquare(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1, i = 0;
        int[] ans = new int[n];
        while (l <= r) {
            if (abs(arr[l]) > abs(arr[r])) {
                ans[i++] = (int) pow(arr[l], 2);
                l++;
            }
            else {
                ans[i++] = (int) pow(arr[r], 2);
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size Of Array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter" + n + "elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = sortSquare(arr);
        System.out.println("Sorted Square Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
