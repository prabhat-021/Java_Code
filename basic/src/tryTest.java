import java.util.*;

public class tryTest {
    public static void main(String[] args) {
//        int[] gain = {105, 924, 32, 968};
//        int[] player2 = {4, 1};
//        int a = isWinner(player1, player2);
//        System.out.println(a);
//        System.out.println(largestAltitude(gain));
//        int[] t=twoSum(gain,-6);
//        for (int i = 0; i < t.length; i++) {
//            System.out.println(t[i]);
//        }
//        System.out.println(checkPowersOfThree(33));
//        System.out.println(checkPowersOfThree(11));
//        System.out.println(checkPowersOfThree(21));
//        System.out.println(checkPowersOfThree(91));
//        System.out.println(checkPowersOfThree(12));

        int[] arr = {5, 7, 2, 3, 8, 1, 4};
        int idx = Partition(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        while (arr[i] < arr[j]) {
            if ((arr[i] + arr[j]) == target) {
                break;
            } else if ((arr[i] + arr[j]) > target) {
                j--;
            } else {
                i++;
            }
        }
        int cout = 0;
        for (int k = 0; k < arr.length; k++) {
            if (arr[i] == nums[k]) {
                arr[i] = k;
                cout++;
            } else if (arr[j] == nums[k]) {
                arr[j] = k;
                cout++;
            }
            if (cout == 2) {
                break;
            }
        }
        return new int[]{arr[i], arr[j]};
    }

    public static int isWinner(int[] player1, int[] player2) {
        int sum1 = sumOfPlayer(player1);
        int sum2 = sumOfPlayer(player2);
        if (sum1 > sum2) {
            return 1;
        } else if (sum1 < sum2) {
            return 2;
        }
        return 0;
    }

    static int sumOfPlayer(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i - 1] == 10) {
                sum = sum + arr[i] * 2;
            } else if (i > 1 && arr[i - 2] == 10) {
                sum = sum + arr[i] * 2;
            } else {
                sum = sum + arr[i];
            }
        }
        return sum;
    }

    public static int largestAltitude(int[] gain) {
        int max = maxElement(prefix(gain));
        return max;

    }

    public static boolean checkPowersOfThree(int n) {
        long sum = 0;
        int t = n;
        int pow = 0;
        while (n > 0) {
            if (n == 1) {
                return true;
            }
            if (n / 3 == 2) {
                return false;
            }
//            if (sum == n) {
//                return true;
//            } else if (sum > n) {
//                return false;
//            } else {
//                sum += Math.pow(3, pow);
//                pow++;
//            }
            int x = 0;
            while (Math.pow(3, x) <= n) {
                x++;
            }
//            if (sum == Math.pow(3, x - 1)) break;
            sum += Math.pow(3, x - 1);
            n = n - (int) Math.pow(3, x - 1);
//            if (x - 1 == 0) break;
        }
        return (int) sum == t;
    }

    static int[] prefix(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = 0;
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
        return prefixSum;
    }

    static int maxElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static boolean check(int[] nums) {
        //    int count=0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                rotate(nums, nums.length - i + 1);
                break;
            }
        }
        if (check2(nums) == 0) return true;
        return false;
    }

    static int check2(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                count++;
            }
        }
        return count;
    }

    static void swapArray(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swapArray(arr, i, j);
            i++;
            j--;
        }
    }

    static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - 1);

    }

    public static int buyChoco(int[] prices, int money) {
        int min1 = 101, min2 = 101;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= min1) {
                min2 = min1;
                min1 = prices[i];
            } else if (prices[i] < min2) {
                min2 = prices[i];
            }
        }
        return (min1 + min2) > money ? money : money - (min1 + min2);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> st = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            st.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (st.contains(nums2[i])) {
                ans.add(nums2[i]);
                st.remove(nums2[i]);
            }
        }

        return ans.stream().mapToInt(number -> number).toArray();

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (mp.containsKey(nums1[i])) {
                mp.put(nums1[i], mp.get(nums1[i]) + 1);
            } else {
                mp.put(nums1[i], 1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (mp.containsKey(nums2[i])) {
                mp.put(nums2[i], mp.get(nums2[i]) - 1);
                ans.add(nums2[i]);
                if (mp.get(nums2[i]) == 0) {
                    mp.remove(nums2[i]);
                }
            }
        }
        return ans.stream().mapToInt(number -> number).toArray();
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> st1 = new HashSet<>();
        HashSet<Integer> st2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            st1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            st2.add(nums2[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll1 = new ArrayList<>();
        List<Integer> ll2 = new ArrayList<>();
//        for (int i = 0; i < nums2.length; i++) {
//            if (!st1.contains(nums2[i])) {
//                ll2.add(nums2[i]);
//            }
//        }
//
//        for (int i = 0; i < nums1.length; i++) {
//            if (!st2.contains(nums1[i])) {
//                ll1.add(nums1[i]);
//            }
//        }
        for (var ele : st1) {
            if (!st2.contains(ele)) {
                ll2.add(ele);
            }
        }
        for (var ele : st2) {
            if (!st1.contains(ele)) {
                ll1.add(ele);
            }
        }
        ans.add(ll2);
        ans.add(ll1);
        return ans;
    }

    public boolean canBeIncreasing(int[] nums) {
        if (nums.length <= 1) return true;
//        Stack<Integer> st=new Stack<>();
//        int i=0,j=i+1;
        int count = 0;
//        st.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
//           while (st.peek()>nums[i]){
//               count++;
//               st.pop();
////               st.push()
//           }
//           st.push(nums[i]);
        }
        return count <= 1;
    }

    private static boolean canBeIncreasing2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                count++;
                if (count == 2) return false;
                if (i > 0 && nums[i - 1] >= nums[i + 1]) nums[i + 1] = nums[i];
            }
        }
        return true;
    }

    public List<String> fizzBuzz(int n) {
        List<String> ls = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) ls.add("FizzBuzz");
            else if (i % 3 == 0) ls.add("Fizz");
            else if (i % 5 == 0) ls.add("Buzz");
            else ls.add(i + "");
        }
        return ls;
    }

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int maxDis = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
        if (maxDis == 0) {
            if (t == 0) return false;
            return true;
        }
        return maxDis <= t;
    }

    public static int Partition(int[] arr, int si, int ei) {
        int item = arr[ei];
        int idx = si;
        for (int i = si; i < ei; i++) {
            if (arr[i] <= item) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                idx++;
            }
        }
        int temp = arr[ei];
        arr[ei] = arr[idx];
        arr[idx] = temp;
        return idx;
    }

    public static int findJudge(int n, int[][] trust) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < trust.length; i++) {
            mp.put(trust[i][0], trust[i][1]);
            arr[trust[i][1]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n - 1) {
                if (!mp.containsKey(i + 1)) {
                    return i + 1;
                }
            }
        }

        return -1;
    }

    public int[] singleNumber(int[] nums) {
        HashSet<Integer> mp = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.contains(nums[i])) mp.remove(nums[i]);
            else mp.add(nums[i]);
        }
        int[] array = new int[mp.size()];
        int index = 0;
        for (int element : mp) {
            array[index++] = element;
        }
        return array;
    }

    public static int[] sortedSquares(int[] nums) {
        int j = nums.length - 1, i = 0, k = nums.length - 1;
        int[] ans = new int[nums.length];
        while (i < j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                ans[k--] = nums[i] * nums[i];
                i++;
            } else {
                ans[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return ans;
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;

        for (int j : arr) {
            if (j % 2 == 0) {
                count = 0;
            } else count++;
            if (count == 3) return true;
        }
        return false;
    }

}



