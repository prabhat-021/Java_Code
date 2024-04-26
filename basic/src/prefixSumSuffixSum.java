import java.util.Scanner;

public class prefixSumSuffixSum {

    static int findArraySum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static boolean EqualPartition(int[] arr) {
        int sum = findArraySum(arr);
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int suffixSum = sum - prefixSum;
            if (suffixSum == prefixSum) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of an array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " elements in the array");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Partition is "+ EqualPartition(arr)+" Possible");
    }
}

