package PracticeProblems;

public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {

    }

    public int longestOnes(int[] nums, int k) {
        int cntZeroes = 0;
        int ans = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) cntZeroes++;

            while (cntZeroes > k) {
                if (nums[i] == 0) cntZeroes--;
                j++;
            }
            ans = Math.max(ans, i-j + 1);
        }
        return ans;
    }
}
