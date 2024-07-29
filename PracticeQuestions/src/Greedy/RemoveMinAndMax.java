package Greedy;

public class RemoveMinAndMax {
    public static void main(String[] args) {

    }

    public int minimumDeletions(int[] nums) {
        int max_idx = 0;
        int min_idx = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[min_idx]) {
                min_idx = i;
            }
            if (nums[i] > nums[max_idx]) {
                max_idx = i;
            }
        }

        int front = Math.max(max_idx + 1, min_idx + 1);
        int back = Math.max(nums.length - max_idx, nums.length - min_idx);

        int bothSide = Math.min(nums.length - max_idx, max_idx + 1) + Math.min(nums.length - min_idx, min_idx + 1);

        return front < back ? (Math.min(front, bothSide)) : Math.min(back, bothSide);
    }
}
