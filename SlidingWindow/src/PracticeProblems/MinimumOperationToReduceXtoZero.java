package PracticeProblems;

public class MinimumOperationToReduceXtoZero {
    public static void main(String[] args) {
        int[] arr = {3, 2, 20, 1, 1, 3};
        int target = 10;
        System.out.println(minOperations(arr, target));
    }

    public static int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) sum += num;

        int i = 0, j = 0, ans = -1, currSum = 0, target = sum - x;
        while (j < nums.length) {
            currSum += nums[j];
            if (currSum == target) ans = Math.max(ans, j - i + 1);
            while (i <= j && currSum > target) {
                currSum -= nums[i++];
                if (currSum == target) ans = Math.max(ans, j - i + 1);
            }
            j++;
        }
        return ans == -1 ? -1 : nums.length - ans;
    }

//    public int minOperations(int[] nums, int x) {
//        int sum = 0, k = 0, ans = Integer.MAX_VALUE, i = 0, j = 0;
//        while (sum < x) {
//            sum += nums[j++];
//            k++;
//        }
//        int sum2 = sum;
//        ans = Math.min(ans, j - i + 1);
////        for (int i = 0; i < k; i++) {
//////            sum2 -= nums[k - i-1];
//////            sum2 += nums[nums.length - i - 1];
//////            if(sum2==x) ans=Math.min(ans,)
//////        }
//        while (j > -1) {
//            sum2 -= nums[j--];
//            sum2 += nums[nums.length - 1 - i];
//            i++;
//            if (sum2 == x) ans = Math.min(ans, j + i + 1);
//            while (sum2 > x && j > -1) {
//                sum2 -= nums[j--];
//                sum2 += nums[nums.length - 1 - i];
//            }
//        }
//        return ans;
//    }
}
