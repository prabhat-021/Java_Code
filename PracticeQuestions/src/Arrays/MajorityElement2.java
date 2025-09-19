package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {
    public static void main(String args[]) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = majorityElement(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }


    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> ll = new ArrayList<>();
        for (int num : nums) {
            if (mp.containsKey(num)) {
                mp.put(num, mp.get(num) + 1);
            } else {
                mp.put(num, 1);
            }
        }
        for (HashMap.Entry<Integer, Integer> entry : mp.entrySet()) {
            int currentValue = entry.getValue();
            if (currentValue > (nums.length / 3)) {
                ll.add(entry.getKey());
            }
        }
        return ll;
    }
}
