import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LargestPalindromicNumber {
    public static void main(String[] args) {
        String demo="313535133";
        List<Integer> ll=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ll.add(0);
        }
        int n=demo.length();
        for (int i = 0; i < n; i++) {
          int digit=demo.charAt(i)-'0';
          ll.set(digit,ll.get(digit)+1);
        }
        if(!validate(demo)){
            System.out.println("Palindrome Not Possible");
            return;
        }

        String result="";
        for (int i = 9; i >=0 ; i--) {
            while (ll.get(i)>1){
                result+=i;
                ll.set(i,ll.get(i)-2);
            }
        }
        for (int i = 9; i >=0 ; i--) {
            if(ll.get(i)==1){
                result+=i;
            }
        }
        System.out.println(result);
// Now reverse and add you will get the answer;

    }

    public static boolean validate(String str) {
        HashSet<Integer> hp = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - '0';
            if (hp.contains(ch)) hp.remove(ch);
            else hp.add(ch);
        }
        return hp.size() < 2;
    }
}
