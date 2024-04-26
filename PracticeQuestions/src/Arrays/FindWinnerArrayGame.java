package Arrays;

public class FindWinnerArrayGame {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4, 6, 7};
        System.out.println(getWinner(arr, 2));
    }

    public static int getWinner(int[] arr, int k) {
        int win_count = 0, tempMax = arr[0];
        if (arr.length <=k || k==1) return findMax(arr);
        for (int i = 1; i < arr.length; i++) {
            if (tempMax > arr[i]) {
                win_count++;
            } else {
                tempMax = arr[i];
                win_count = 1;
            }
            if (win_count == k) {
                return tempMax;
            }
        }
        return tempMax;
    }

//    public static void leftRotateByOne(int[] arr) {
//        int temp = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            arr[i - 1] = arr[i];
//        }
//        arr[arr.length - 1] = temp;
//    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
