package Arrays;

public class NitherMaxNorMinimum {
    public static void main(String[] args) {
        int[] arr = {3, 30, 24};
        findNonMinOrMax(arr);
    }

    public static int findNonMinOrMax(int[] nums) {
        int ans = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n != min && n != max) {
                ans = nums[i];
                break;
            }
        }

        return nums.length <= 2 ? -1 : ans;
    }
}
