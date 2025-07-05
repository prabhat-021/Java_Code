public class ArrrayImplementation {

    public static class Stack {
        private int[] arr = new int[10];
        private int idx = 0;

        void push(int val) {
            if (isFull()) {
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

        void pop() {
            if (idx > 0) {
                int top = arr[idx - 1];
                arr[idx - 1] = 0;
                idx--;
                return;
            }
            System.out.println("Stack is Empty");
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

        boolean isEmpty() {
            return idx == 0;
        }

        boolean isFull() {
            return idx == arr.length;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();
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
