package PracticeProblems;

public class MinimalSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 11;
        System.out.println(minSubArrayLen(target, arr));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, sum = 0, ans = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            if (sum >= target) ans = Math.min(ans, j - i + 1);
            while (sum > target) {
                sum -= nums[i++];
                if (sum >= target) ans = Math.min(ans, j - i + 1);
            }
            j++;
        }
        if(ans == Integer.MAX_VALUE) return 0;
        return ans;
    }
}
