package PracticeProblems;

public class CountSubarrayWithScoreLessThanK {
    public static void main(String[] args) {

    }

    public long countSubarrays(int[] nums, long k) {
        int sum = 0, i = 0, j = 0, count = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum * (j - i + 1) >= k) {
                sum -= nums[i];
                i++;
            }
            count += (j - i + 1);
            j++;
        }
        return count;
    }

//    public static long countSubarrays(int[] nums, long k) {
//        int i = 0, j = 0;
//        long count = 0;
//        while (j < nums.length && i < nums.length) {
//            if (checkProduct(nums, i, j, k)) {
//                count++;
//                if (j == nums.length-1) continue;
//                else j++;
//            } else {
//                if (i < j) i++;
//                // else {
//                //     i++;
//                //     j++;
//                // }
//                // continue;
//            }
//        }
//        return count;
//    }
//
//    public static boolean checkProduct(int[] nums, int i, int j, long value) {
//        long product = 0;
//        for (int k = i; k <= j; k++) {
//            product += nums[i];
//            if ((product * (j - i + 1)) > value) return false;
//        }
//        return (product * (j - i + 1)) < value;
////        return product;
//    }
}
