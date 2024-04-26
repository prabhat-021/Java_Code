package Algorithm;
// SETP 1:
// STRING TOT = PAT + "$" + STRING

//STEP2:
//       0 1 2 3 4 5 6 7 8 9
// TOT = A B A $ A B A B A A
//
//PAT=ABA (LENGTH=3)
//
//Z[]=    0 0 1 0 3 0 3 0 1 1
//        0 1 2 3 4 5 6 7 8 9
//
//4,6
//
//4-3-1=0;
//6-3-1=2;
//
//0 2
//STRING = ABABAA
//         012345

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
    public static void main(String[] args) {
        String pat = "ab", str = "ababaaab";
        String tot = pat + "$" + str;
        long[] ans = z_algo(tot);
        for (int i = 0; i < ans.length; i++) {
//            System.out.print(ans[i] + " ");
            if (ans[i] == pat.length()) {
                System.out.println(i - pat.length() - 1);
            }
        }
//        necessary:- 1<=l<=i<=r<tot.length();
//        if(i>r);
//        l=i;
//        r=i;
//
//        l=r=0;
//        while(r<tot.length() && tot[r]==tot[r-l])
//            r++;
//        z[i]=r-l;
//        r--;

//        else if(i<=r){
//
//        }
    }

    public static long[] z_algo(String str) {
        long len = str.length();
        long l = 0, r = 0;
        long[] list = new long[(int) len];
        for (long i = 1; i < len; i++) {
            if (i > r) {
                l = r = i;
                while (r < len && str.charAt((int) r) == str.charAt((int) (r - l))) r++;
                list[(int) i] = r - l;
                r--;
            } else {
                long idx = i - l;
                if (i + list[(int) idx] <= r) list[(int) i] = list[(int) idx];
                else {
                    l = i;
                    while (r < len && str.charAt((int) r) == str.charAt((int) (r - l))) r++;
                    list[(int) i] = r - l;
                    r--;
                }
            }
        }
        return list;
    }

}
