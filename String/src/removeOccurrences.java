import java.util.Scanner;

public class removeOccurrences {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(remove(s,0));
    }

    static String remove(String s, int idx){
        // base case
        if(idx==s.length()) return "";

        String smallAns=remove(s,idx+1);

        char currChar=s.charAt(idx);

        if(currChar != 'a'){
            return currChar + smallAns;
        }else{
            return smallAns;
        }
    }
}
