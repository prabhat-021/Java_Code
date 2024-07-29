package Stack.Practice;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

    }

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//
//        int[] ll = new int[nums.length - k+1];
//        for (int i = 0; i < k; i++) {
//            queue.add(nums[i]);
//        }
//        int j = 0;
//
//        ll[j++] = queue.peek();
//
//        queue.remove(nums[0]);
//
//        for (int i = k; i < nums.length; i++) {
//            queue.add(nums[i]);
//
//            ll[j++] = queue.peek();
//
//            queue.remove(nums[i - k + 1]);
//        }
//
//        return ll;
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ll = new int[nums.length - k+1];
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peek() == i - k) dq.poll();
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();

            dq.offer(i);

            if (i >= k - 1) ll[j++] = nums[dq.peek()];
        }

        return ll;
    }

}
