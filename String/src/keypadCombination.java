import java.util.ArrayList;
import java.util.List;

public class keypadCombination {
    public static void main(String[] args) {
        String dig = "23";

    }

//    time Complexity id O(n*4^n);

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] kp = {"", "", "abc", "def", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.isEmpty()) return ans;
        combination(digits, "", kp, ans);
        return ans;
    }

    static void combination(String digit, String result, String[] kp, List<String> ans) {
// base case
        if (digit.length() == 0) {
//            System.out.print(result + " ");
            ans.add(result);
            return;
        }

        int currNum = digit.charAt(0) - '0';
        String currchoices = kp[currNum];
        for (int i = 0; i < currchoices.length(); i++) {
            combination(digit.substring(1), result + currchoices.charAt(i), kp, ans);
        }
    }
}
