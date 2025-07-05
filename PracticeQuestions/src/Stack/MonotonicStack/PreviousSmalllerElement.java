package Stack.MonotonicStack;

import java.util.Stack;

public class PreviousSmalllerElement {
    public static void main(String[] args) {
        int[] arr={5,7,9,6,7,4,5,1,3,7};
        int[] ans = findNSE(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] findNSE(int[] nums){
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if(st.isEmpty()){
                ans[i]=-1;
                st.push(nums[i]);
            }else {
                while (!st.empty() && st.peek() > nums[i]){
                    st.pop();
                }
                if(st.isEmpty()) ans[i]=-1;
                else ans[i]=st.peek();
                st.push(nums[i]);
            }
        }
        return ans;
    }
}
