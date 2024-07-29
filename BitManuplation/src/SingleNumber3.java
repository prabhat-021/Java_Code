public class SingleNumber3 {
    public static void main(String[] args) {

    }

    public int[] singleNumber(int[] nums) {
        long xor = 0;
        for (int j : nums) xor = xor ^ j;

        long rightMost = (xor & (xor - 1)) ^ xor;
        int b1 = 0, b2 = 0;

        for (int num : nums) {
            if ((num & rightMost) != 0) {
                b1 = b1 ^ num;
            } else {
                b2 = b2 ^ num;
            }
        }
        return new int[]{b1, b2};
    }
}
