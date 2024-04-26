package PracticeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
////        List<Integer> ll = new ArrayList<>();
//        int[] ans = new int[nums.length - k + 1];
//        int i = 0, j = 0, max = Integer.MIN_VALUE;
//        for (int l = 0; l < k; l++) {
//            max = Math.max(max, nums[j++]);
//        }
////        ll.add(max);
//        ans[0] = max;
//        while (j < nums.length) {
//            if (nums[j] > max) max = nums[j];
//            i++;
//            j++;
//            ans[i] = max;
//        }
//        return ans;
        if(nums == null || k <= 0) return new int [0];
        int [] arr = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length - k + 1; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            arr[i] = max;
        }
        return arr;


    }
}
