package Arrays;

public class TotalHammingDistance {
    public static void main(String[] args) {

    }

    public static int totalHammingDistance(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += (nums[j] >> i) & 1;
            }
            ans += count * (nums.length - count);
        }

        return ans;
    }
}
