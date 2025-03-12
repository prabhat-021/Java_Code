public class ArrrayImplementation {

    public static class Stack {
        private int[] arr = new int[10];
        private int idx = 0;

        void push(int val) {
            if(isFull()){
                System.out.println("Stack is Full");
                return;
            }
            arr[idx] = val;
            idx++;
        }

        int peek() {
            if (idx > 0) return arr[idx - 1];
            return -1;
        }

        int pop() {
            if (idx > 0) {
                int top = arr[idx - 1];
                arr[idx - 1] = 0;
                idx--;
                return top;
            }
            System.out.println("Stack is Empty");
            return -1;
        }

        void display() {
            for (int i = 0; i < idx; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        int size() {
            return idx;
        }

        boolean isEmpty(){
            if(idx==0) return true;
            return false;
        }

        boolean isFull(){
            if(idx== arr.length) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(9);
        st.display();
        st.push(7);
        st.display();
        st.push(6);
        st.display();
        System.out.println(st.peek());
        System.out.println(st.size());
        st.pop();
        st.display();
    }

}
