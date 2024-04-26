package Arrays;

import java.util.Collection;
import java.util.Collections;

public class nextPermutation {
    public static void main(String[] args) {

    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if (nums == null || nums.length <= 1) {
            return;
        }
        int idx = -1;
        for (int i = n - 2; i > 0; i++) {
            if (nums[i] > nums[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            reverse(nums, 0, n - 1);
        }

        for (int i = n - 1; i > idx; i++) {
            if (nums[i] > nums[idx]) {
                swap(nums, i, idx);
                break;
            }
        }
        reverse(nums, idx + 1, n - 1);

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);

    }
}
