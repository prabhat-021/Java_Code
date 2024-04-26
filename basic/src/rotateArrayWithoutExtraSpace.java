import java.util.Scanner;

public class rotateArrayWithoutExtraSpace {
    static void swapArray(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swapArray(arr, i, j);
            i++;
            j--;
        }
    }

    static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - 1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of an array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " elements in the array");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Enter the Steps to be rotated");
        int k = sc.nextInt();
        System.out.println("Original array is:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
        rotate(arr, k);
        System.out.println("\nRotated array is:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
    }
}
