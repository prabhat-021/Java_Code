package Stack.Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ImplementingStackFromQueue {
    public static void main(String[] args) {

    }

    public static class ImplementStack {
        Queue<Integer> qp = new LinkedList<>();

        void push(int ele) {
            qp.add(ele);
            int s = qp.size();
            for (int i = 0; i < s; i++) {
                qp.add(qp.poll());
            }
        }

        int pop(){
            if(qp.isEmpty()) return -1;
            return qp.poll();
        }
    }

    public static class ImplementQueue{
        Stack<Integer> st=new Stack<>();

        void push(int ele){
            Stack<Integer> st1=new Stack<>();
            while (!st.isEmpty()){
                st1.push(st.pop());
            }
            st.push(ele);
            while (!st1.isEmpty()){
                st.push(st1.pop());
            }
        }

        void pop(){
            System.out.println(st.pop());
        }
    }
}
