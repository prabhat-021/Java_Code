public class cycleInLinkedList {
    public static void main(String[] args) {

    }

    public boolean hasCycle(basics.Node head) {
        if(head==null || head.next==null) return false;
        basics.Node slow=head;
        basics.Node fast=head;
        while(fast!=null){
            if(slow==null) return false;
            slow=slow.next;
            if(fast.next==null) return false;
            fast=fast.next.next;
            if(fast==slow) return true;
        }
        return false;
    }

    public basics.Node detectCycle(basics.Node head) {
        if(head==null || head.next==null) return null;
        basics.Node slow=head;
        basics.Node fast=head;
        while(fast!=null){
            if(slow==null) return null;
            slow=slow.next;
            if(fast.next==null) return null;
            fast=fast.next.next;
            if(fast==slow) break;
        }
        basics.Node temp=head;
        while(temp!=slow){
            if(slow==null) return null;
            slow=slow.next;
            temp=temp.next;
        }
        return temp;
    }
}
