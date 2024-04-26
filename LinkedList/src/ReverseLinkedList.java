public class ReverseLinkedList {
    public static void main(String[] args) {
        basics.linkedList l4=new basics.linkedList();
        l4.insertAtBeginning(3);
        l4.insertAtIndex(1,5);
        l4.insertAtIndex(2,1);
        l4.insertAtIndex(3,2);
        l4.insertAtIndex(4,4);
        l4.display();
        basics.Node r=reverseLinkedList(l4.head);

    }

    public static basics.Node reverseLinkedList(basics.Node head){
        if(head==null || head.next==null) return head; // Base Case.

       basics.Node newHead= reverseLinkedList(head.next); // Call.

        head.next.next=head; //interChanging Node .
        head.next=null;
        return newHead;
    }
    public static basics.Node reverseItrative(basics.Node head){
        basics.Node curr=head;
        basics.Node pre=null;
        basics.Node after=null;
        while(curr!=null){
            after=curr.next;
            curr.next=pre;
            pre=curr;
            curr=after;
        }
        return pre;
    }
}
