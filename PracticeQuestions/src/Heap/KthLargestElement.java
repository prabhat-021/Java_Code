package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        for (int i = 0; i < k-1; i++) {
            pq.poll();
        }

        return pq.peek();
    }
}
