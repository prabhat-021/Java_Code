package PracticeProblems;

public class BinarySubarrayWithSum {
    public static void main(String[] args) {

    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int i = 0, j = 0, count = 0, temp = 0, sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            if (nums[j] == 1) temp = 0;
            if (sum > goal) {
                sum -= nums[i];
                i++;
            }
            while (sum == goal && i <= j) {
                temp++;
                sum -= nums[i];
                i++;
            }
            j++;
            count += temp;
        }
        return count;
    }

    public int numSubarraysWithSum1(int[] nums, int goal) {
        return atmostK(nums, goal) - atmostK(nums, goal-1);
    }
    private int atmostK(int[] nums, int goal) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = 0;

        while(i < nums.length) {
            sum += nums[i];

            while(j<=i && sum > goal) {
                sum -= nums[j];
                j++;
            }
            ans += i-j+1;
            i++;
        }
        return ans;
    }
}
