package Arrays;

public class KadanesAlgorithm {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public int maxProductArray(int[] nums) {
        int pro = 1, maxPro = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pro *= nums[i];

            if (pro > maxPro) {
                maxPro = pro;
            } else if (pro < 0) {
                pro =maxPro= 1;
            }

        }
        return maxPro;
    }
}
