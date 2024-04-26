public class LinkedlistImplementation {
    public static class Node{
        int val;
        Node next;

        Node(int val){
            this.val=val;
        }
    }

    public static class LLStack{
        Node head=null;
        private int size=0;
        void push(int x){
            Node temp=new Node(x);
            temp.next=head;
            head=temp;
            size++;
        }

       int pop(){
            if(head==null){
                System.out.println("Stack is Empty");
                return -1;
            }
            int top= head.val;
                    head=head.next;
            return top;
        }
        int peek(){
            if(head==null){
                System.out.println("Stack is Empty");
                return -1;
            }
            return head.val;
        }
        void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
            System.out.println();
        }
        int size(){
            return size;
        }
    }

    public static void main(String[] args) {
        LLStack st = new LLStack();
        st.push(9);
        st.display();
        st.push(7);
        st.display();
        st.push(6);
        st.display();
        System.out.println(st.size());
        st.pop();
        st.display();
    }
}
