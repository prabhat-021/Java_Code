import java.util.HashMap;

public class LargestSubarrayWith0Sum {
    public static void main(String[] args) {

    }

    int zeroSumLargestSubarray(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int maxlen = 0, prefixsum = 0;
        mp.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            prefixsum += arr[i];
            if (mp.containsKey(prefixsum)) {
                maxlen = Math.max(maxlen, i - mp.get(prefixsum));
            } else {
                mp.put(prefixsum, i);
            }
        }
        return maxlen;
    }
}
