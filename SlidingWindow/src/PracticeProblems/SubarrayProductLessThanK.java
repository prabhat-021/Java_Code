package PracticeProblems;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        int k=0;
        System.out.println(numSubarrayProductLessThanK(arr,k));;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0, j = 0, count = 0;
        long product = 1;
        while (j < nums.length ) {
            product *= nums[j];
            while (product >= k) {
                product /= nums[i];
                i++;
            }
            count += (j - i + 1);
            j++;
        }
        return count;
    }
}
