import org.w3c.dom.ls.LSOutput;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKelement {
    public static void main(String[] args) {
        Queue<Integer> qp = new LinkedList<>();
//        reverseAqueue(qp);
        qp.add(1);
        qp.add(2);
        qp.add(3);
        qp.add(4);
        qp.add(5);
        ReverseK_Element(qp,3);
        int size= qp.size();
        for (int i = 0; i < size; i++) {
            System.out.println(qp.remove() + " ");
        }
    }

    static void reverseAqueue(Queue<Integer> qp) {
        Stack<Integer> st = new Stack<>();
        while (qp.size() > 0) {
            st.push(qp.remove());
        }
        while (st.size() > 0) {
            qp.add(st.pop());
        }
    }

    static void ReverseK_Element(Queue<Integer> qp, int k) {
        Stack<Integer> st = new Stack<>();
        if(k> qp.size()){
            System.out.println("Not Enough Element");
            return;
        }
        int size= qp.size();
        while (qp.size() > (size - k)) {
            st.push(qp.remove());
        }
        while (st.size() > 0) {
            qp.add(st.pop());
        }
        while (size > k){
            qp.add(qp.remove());
            size--;
        }
    }
}
