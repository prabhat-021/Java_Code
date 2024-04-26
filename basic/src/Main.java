import java.util.Scanner;

public class Main {
    static int maxInteger(int[] arr){
        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
       return maxValue;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int firstMaxElement=maxInteger(arr);
        for(int i=0;i<n;i++){
            if(arr[i]==firstMaxElement){
                arr[i]=Integer.MIN_VALUE;
            }
        }
        int secondMaxElement=maxInteger(arr);
        System.out.println("SECOND MAX ELEMENT IS :" + secondMaxElement);
    }
}