import java.util.HashMap;
import java.util.Map;

public class MaxFreq {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 1, 4, 4, 6, 4, 4, 4};
        Map<Integer, Integer> freq = new HashMap<>();
        for (int el : arr
        ) {
            if (!freq.containsKey(el)) {
                freq.put(el, 1);
            } else {
                freq.put(el, freq.get(el) + 1);
            }
        }
        System.out.println("Frequency");
        System.out.println(freq.entrySet());
        int maxFreq=0, anskey=-1;
        for(var e: freq.entrySet()){
            if(e.getValue()>maxFreq){
                maxFreq=e.getValue();
                anskey=e.getKey();
            }
        }
        System.out.println(anskey);
    }
}
