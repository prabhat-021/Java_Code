package Greedy;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = {2, 5, 0, 0};
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] nums) {
//        return jump(nums, nums[0], 0, false);
        int winner = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= winner) {
                winner = i;
            }
        }

        return winner == 0;
    }
//  BRUTE FORCE
//    public static boolean jump(int[] arr, int jumpMax, int ptr, boolean flag) {
//        if (arr.length - 1 == ptr) return true;
//        else if (ptr >= arr.length) {
//            return false;
//        }
//
//        for (int i = ptr; i < arr.length - 1; i++) {
//            if (arr[ptr] == 0) return false;
//            while (arr[ptr] != 0 && !flag) {
//                if (arr[ptr] + ptr > arr.length - 1) return true;
//                flag = jump(arr, arr[ptr + jumpMax], ptr + jumpMax, flag);
//                jumpMax=--arr[ptr];
//            }
//            if (flag) break;
//        }
//
//        return flag;
//    }
}
