public class Palindromic_Substring {
    public static void main(String[] args) {

    }

    public static int CountPalindrome(String s) {
        int count = 0;
///      ODD
        for (int axis = 0; axis < s.length(); axis++) {
            for (int orbit = 0; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
                if (s.charAt(axis - orbit) != s.charAt(axis + orbit)) break;
                count++;
            }
        }
//        EVEN
        for (double axis = 0.5; axis < s.length(); axis++) {
            for (int orbit = 0; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
                if (s.charAt((int) (axis - orbit)) != s.charAt((int) (axis + orbit))) break;
                count++;
            }
        }
        return count;
    }
}
