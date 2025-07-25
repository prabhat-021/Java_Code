package Arrays;

public class KadanesAlgorithm {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = 0;
        for (int num : nums) {
            sum += num;

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
        for (int num : nums) {
            pro *= num;

            if (pro > maxPro) {
                maxPro = pro;
            } else if (pro < 0) {
                pro = maxPro = 1;
            }

        }
        return maxPro;
    }

    public int maxProduct(int[] nums) {

        int n = nums.length;
        int left = 1, right = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {

            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;

            left *= nums[i];   //prefix product
            right *= nums[n - 1 - i];    //suffix product

            ans = Math.max(ans, Math.max(left, right));

        }

        return ans;

    }
}
