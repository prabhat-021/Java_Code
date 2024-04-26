import java.util.Scanner;

public class sortArray0or1 {

    static void swapArray(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sortZerosAndOnces(int[] arr) {
        int n = arr.length - 1;
        int i = 0, j = n;
        while (i < j) {
            if (arr[i] == 1 && arr[j] == 0) {
                swapArray(arr, i, j);
                i++;
                j--;
            }
            if (arr[i] == 0) {
                i++;
            }
            if (arr[j] == 1) {
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter Array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sortZerosAndOnces(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
    }
}
