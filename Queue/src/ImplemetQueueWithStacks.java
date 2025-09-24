import java.util.Stack;

public class ImplemetQueueWithStacks {
    public static void main(String[] args) {

    }

    public class MyQuue{
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        public void push(int x){
            st1.push(x);
        }

        public int pop(){
            while (st1.size()>1){
                st2.push(st1.pop());
            }
            int item= st1.pop();
            while (!st2.isEmpty()){
                st1.push(st2.pop());
            }
            return item;
        }

        public int peek(){
            while (st1.size()>1){
                st2.push(st1.pop());
            }
            int item= st1.peek();
            while (!st2.isEmpty()){
                st1.push(st2.pop());
            }
            return item;
        }

        public boolean empty(){
            return st1.empty();
        }
    }

}
