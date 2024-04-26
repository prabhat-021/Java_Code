//import java.util.Scanner;
import java.util.Stack;

public class CopyStack {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
//
//        User Input
//
//        Scanner sc=new Scanner(System.in);
//        int n;
//        System.out.println(" Enter the no. Of Element");
//        n=sc.nextInt();
//        for (int i = 0; i < n; i++) {
//          int x= sc.nextInt();
//          st.push(x);
//        }
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        System.out.println(st);

        Stack<Integer> gt=new Stack<>();
        while (st.size()>0){
            gt.push(st.pop());
        }

        Stack<Integer> rt=new Stack<>();
        while (gt.size()>0){
            rt.push(gt.pop());
        }

        System.out.println(rt);
    }
}
