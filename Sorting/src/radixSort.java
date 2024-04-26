public class radixSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 115, 12, 222, 332, 442, 442, 552, 2, 562, 2, 2, 2};
        System.out.println("Array before sorting");
        CountSort.printArray(arr);
        RadixSort(arr);
        System.out.println("Array After sorting");
        CountSort.printArray(arr);
    }

    static void RadixSort(int[] arr) {
        int max = CountSort.findMax(arr);
        for (int place = 1; max / place > 0; place *= 10) {
            countSort(arr, place);
        }
    }

    static void countSort(int[] arr, int place) {
        int max = CountSort.findMax(arr); //find the largest element of the array
        int[] output = new int[arr.length];
        int[] count = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            count[(arr[i]/place)%10]++;
        }
//        make preFix array of count array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
//        Find the index of the Each Element in the orignal array and put it in output array
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = count[(arr[i]/place)%10] - 1;
            output[idx] = arr[i];
            count[(arr[i]/place)%10]--;
        }

        for (int i = 0; i < output.length; i++) {
            arr[i] = output[i];
        }

    }
}
