import java.util.Scanner;

public class prefixSum {
    static int[] prefix(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0]=arr[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+arr[i];
        }
        return prefixSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size Of Array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Prefix Array: ");
        int[] prefixSum = prefix(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(prefixSum[i] + " ");
        }
    }
}
