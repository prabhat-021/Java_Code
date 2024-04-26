public class keypadCombination {
    public static void main(String[] args) {
        String dig = "23";
        String[] kp = {"", "", "abc", "def", "jkl", "mno", "pqrs", "tuv", "wxyz"};
combination(dig,"",kp);
    }

//    time Complexity id O(n*4^n);

    static void combination(String digit, String result, String[] kp) {
// base case
        if (digit.length() == 0) {
            System.out.print(result + " ");
            return;
        }

        int currNum=digit.charAt(0)-'0';
        String currchoices=kp[currNum];
        for (int i = 0; i < currchoices.length(); i++) {
            combination(digit.substring(1),result+ currchoices.charAt(i),kp);
        }
    }
}
