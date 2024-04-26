public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 5, 2,5,5,5,1,1,1,1,2,2,2};
        int n = arr.length;
        System.out.println("Array before sorting");
        printArray(arr);
        quickSort(arr, 0, n - 1);
        System.out.println("\nArray after sorting");
        printArray(arr);
    }

    static int partition(int[] arr, int st, int end) {
        int pivot = arr[st];
        int count = 0;
        for (int i = st + 1; i <= end; i++) {
            if (arr[i] <= pivot) count++;
        }
        int pivotidx = st + count;
        swap(arr, st, pivotidx);

//        elemnts lesser or equal left of pivotIndex, greator --> right side of pivotIdx
        int i = st, j = end;
        while (i < pivotidx && j > pivotidx) {
            while (arr[i] <= pivot) i++;
            while (arr[j] > pivot) j--;
            if (i < pivotidx && j > pivotidx) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return pivotidx;
    }

    static void quickSort(int[] arr, int st, int end) {
        if (st >= end) return;
        int pi = partition(arr, st, end);
        quickSort(arr, st, pi - 1);
        quickSort(arr, pi + 1, end);
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static void printArray(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
