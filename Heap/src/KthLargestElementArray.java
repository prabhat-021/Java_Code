import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementArray {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
    }

    public int KthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        return pq.peek();
    }


}
