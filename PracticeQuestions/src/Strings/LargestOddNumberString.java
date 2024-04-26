package Strings;

public class LargestOddNumberString {
    public static void main(String[] args) {
        String num = "7542351161";
        System.out.println(largestOddNumber(num));
    }

    public static String largestOddNumber(String num) {
        String max = "";
        String ans="";
        for (int i = 0; i < num.length(); i++) {
            long ch = num.charAt(i) - '0';
            max=max+ch;
//            max = max * 10 + ch;
            if (ch % 2 != 0) ans = max+"";
        }
        return ans;
    }
}
