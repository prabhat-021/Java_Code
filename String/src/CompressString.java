public class  CompressString {
    public static void main(String[] args) {
        String str="aaaabbbccdde";
        String ans=""+str.charAt(0);
        int count=1;
        for (int i = 1; i < str.length(); i++) {
            char curr=str.charAt(i);
            char pre=str.charAt(i-1);
            if(curr==pre){
                count++;
            }else {
                if(count>1) ans+=count;
                count=1;
                ans+=curr;
            }
        }
        if(count>1) ans+=count;
        System.out.println(ans);
    }
}
