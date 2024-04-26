public class deleteMiddleElement {
    public static void main(String[] args) {

    }

    public basics.Node deleteMiddle(basics.Node head) {
        if(head.next==null) return null;
        basics.Node slow=head;
        basics.Node fast=head;
        while(fast.next.next!=null && fast.next.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
