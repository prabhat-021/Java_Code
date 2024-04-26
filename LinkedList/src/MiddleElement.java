public class MiddleElement {
//
//    hint1: slow fast Pointer
//    hint2: fast=2X speed
//
    public static void main(String[] args) {

    }

    public basics.Node middleNode(basics.Node head) {
        basics.Node slow=head;
        basics.Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
