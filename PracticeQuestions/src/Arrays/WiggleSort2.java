package Arrays;

import java.util.Arrays;

public class WiggleSort2 {
    public static void main(String[] args) {
        int[] arr = {1,4,3,4,1,2,1,3,1,3,2,3,3};
        wiggleSort(arr);
    }

//    public static void wiggleSort(int[] nums) {
//        int[] ans = Arrays.copyOf(nums, nums.length);
//        // int i=1;
//        // while(i<nums.length-1){
//        //     swapArray(nums,i,i+1);
//        //     i+=2;
//        // }
//        // return nums;
//        Arrays.sort(ans);
//        int i = (nums.length / 2) , j = nums.length - 1, k = 0;
//        while (i >= 0) {
//            nums[k++] = ans[i--];
//            if (j > nums.length / 2) nums[k++] = ans[j--];
//        }
//
//    }

    public static void wiggleSort(int[] nums) {
        int n=nums.length-1;
        int[] ans= Arrays.copyOf(nums,nums.length);
        // int i=1;
        // while(i<nums.length-1){
        //     swapArray(nums,i,i+1);
        //     i+=2;
        // }
        // return nums;
        Arrays.sort(ans);
        for(int i=1;i<nums.length;i+=2)
            nums[i]=ans[n--];
        for(int i=0;i<nums.length;i+=2)
            nums[i]=ans[n--];

    }
}

