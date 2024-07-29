public class SingleNumber2 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int bitIdx = 0; bitIdx < 32; bitIdx++) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & (1 << bitIdx)) != 0) count++;
            }
            if (count % 3 == 1) ans = ans | (1 << bitIdx);
        }

        return ans;
    }
}
