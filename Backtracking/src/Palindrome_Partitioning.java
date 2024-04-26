import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    public static void main(String[] args) {
        String ques = "nitin";
        List<String> ll = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        partitioning(ques, ll, ans);
        System.out.println(ans);
    }

    public static void partitioning(String ques, List<String> ll, List<List<String>> ans) {
        if (ques.length() == 0) {
//            System.out.println(ans);
            ans.add(new ArrayList<>(ll));
        }

        for (int i = 1; i <= ques.length(); i++) {
            String s = ques.substring(0, i);
            ll.add(s);
            if (isPalindrome(s)) partitioning(ques.substring(i), ll, ans);
            ll.remove(ll.size()-1);
        }
    }

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
