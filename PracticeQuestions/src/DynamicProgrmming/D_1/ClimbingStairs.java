package DynamicProgrmming.D_1;

public class ClimbingStairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int prev2 = 1;
        int prev = 1;

        for (int i = 2; i <= n; i++) {
            int curr_i = prev + prev2;
            prev2 = prev;
            prev = curr_i;
        }
        return prev;
    }
}
