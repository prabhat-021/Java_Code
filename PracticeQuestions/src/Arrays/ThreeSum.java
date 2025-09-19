package Arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 1, 1, 2};
        int n = arr.length;
//        List<List<Integer>> ans = bruteForce(n, arr);
        List<List<Integer>> ans = optimal(n, arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

    static List<List<Integer>> bruteForce(int n, int[] arr) {
        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
//         Store the set Elements in the Answer:
        List<List<Integer>> ans = new ArrayList<>();
        return ans;
    }

    public static List<List<Integer>> optimal(int n, int[] arr) {
        List<List<Integer>> st = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> ll = Arrays.asList(arr[i], arr[j], arr[k]);
                    st.add(ll);
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        return st;
    }
}
