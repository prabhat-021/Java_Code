package Arrays;

import java.util.Collections;
import java.util.HashSet;
//import java.util.st;

public class ThirdMaximumNumber {
    public static void main(String[] args) {

    }

    public int thirdMax(int[] nums) {
        HashSet<Integer> st=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            st.add(nums[i]);
        }
        if (st.size() >= 3) {
            st.remove(Collections.max(st));
            st.remove(Collections.max(st));
        }
        return Collections.max(st);

    }
}
