public class CountSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int n = arr.length;
        System.out.println("Array before sorting");
        printArray(arr);

        countSort(arr);
        System.out.println("Array after sorting by alternate method");
        printArray(arr);
    }


    static void basicCountSort(int[] arr) {
        int max = findMax(arr); //find the largest element of the array
        int[] count = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int k = 0;

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k++] = i;
            }
        }
    }

    static void countSort(int[] arr) {
        int max = findMax(arr); //find the largest element of the array
        int[] output = new int[arr.length];
        int[] count = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
//        make preFix array of count array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
//        Find the index of the Each Element in the orignal array and put it in output array
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = count[arr[i]] - 1;
            output[idx] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < output.length; i++) {
            arr[i] = output[i];
        }

    }

    static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    static void printArray(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
