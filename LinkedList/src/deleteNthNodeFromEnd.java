public class deleteNthNodeFromEnd {
    public static void main(String[] args) {
        basics.linkedList l3=new basics.linkedList();
        l3.insertAtBeginning(30);
        l3.insertAtBeginning(31);
        l3.insertAtBeginning(32);
        l3.insertAtBeginning(33);
        l3.insertAtBeginning(34);
        l3.insertAtBeginning(35);
        l3.display();
        System.out.println();
//        basics.Node slow=NthNodeFromEnd.nthNode(l3.head,1);
//        slow.data=slow.next.data;
//        slow.next=slow.next.next;
        deleteNthNodeFromEnd(l3.head,1);
        l3.display();
    }
     public static basics.Node deleteNthNodeFromEnd(basics.Node head,int n){
         basics.Node slow = head;
         basics.Node fast = head;
         for (int i = 1; i <= n; i++) {
             fast = fast.next;
         }
         while (fast.next!= null) {
             slow = slow.next;
             fast = fast.next;
         }
         if(fast==null) head=head.next;
         // slow.val=slow.next.val;
         slow.next=slow.next.next;
         return head;
     }
}

