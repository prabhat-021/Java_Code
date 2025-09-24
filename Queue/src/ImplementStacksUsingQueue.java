import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStacksUsingQueue {
    public static void main(String[] args) {
    }

    public class Stack {
        Queue<Integer> qp = new ArrayDeque<>();

        void push(int val) {
            qp.add(val);
        }

        int peek() {
            int size = qp.size();
            for (int i = 0; i < (size - 1); i++) {
                qp.add(qp.remove());
            }
            int x = qp.peek();
            qp.add(qp.remove());
            return x;
        }

        int pop(){
            int size = qp.size();
            for (int i = 0; i < (size - 1); i++) {
                qp.add(qp.remove());
            }
            int x = qp.remove();
//            qp.add(x);
            return x;
        }

        boolean empty(){
            return qp.size()==0;
        }
    }

}
