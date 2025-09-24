package Greedy;

public class JumpGame2 {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    public static int jump(int[] nums) {
        int jump = 0, winner = 0, lastIdx = 0;

        if (nums.length == 1) return 0;

        for (int i = 0; i < nums.length; i++) {
            winner = Math.max(winner, i + nums[i]);

            if (i == lastIdx) {
                lastIdx = winner;
                jump++;
            }

            if (winner >= nums.length - 1) return jump;
        }
        return jump;
    }
}
