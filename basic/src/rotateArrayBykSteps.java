import java.util.Scanner;

public class rotateArrayBykSteps {
    static int[] rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] ans = new int[n];
        int j = 0;
        for (int i = n - k; i < n ; i++) {
            ans[j++] = arr[i];
        }
        for (int i = 0; i < n-k; i++) {
            ans[j++] = arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of an array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " elements in the array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the Steps to be rotated");
        int k = sc.nextInt();
        int[] ans = rotate(arr, k);
        System.out.println("Orignal array is:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("\nRotated array is:");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]);
        }
    }
}
