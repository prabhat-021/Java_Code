package AdityaVerma;

import java.util.ArrayList;

public class FirstNegativeNumberInEveryWindow {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> firstNegative(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> temporary = new ArrayList<>();
        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] < 0) temporary.add(arr[j]);
            if (j - i + 1 < k) j++;
            else if (j - i + 1 == k) {
                if(temporary.size()==0) ans.add(0);
                else{
                    ans.add(temporary.get(0));
                    if (temporary.get(0) == arr[i]) temporary.remove(0);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
