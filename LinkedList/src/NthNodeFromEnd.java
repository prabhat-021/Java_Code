

public class NthNodeFromEnd {
    //    Nth from last =(m-n+1)th node form start
//    m=size
//    n=position
    public static void main(String[] args) {
        basics.linkedList l2 = new basics.linkedList();
        l2.insertAtBeginning(20);
        l2.insertAtBeginning(21);
        l2.insertAtBeginning(22);
        l2.insertAtBeginning(23);
        l2.insertAtBeginning(24);
        l2.insertAtBeginning(25);
        l2.display();
        System.out.println();
        System.out.println(nthNode(l2.head,4).data);
        System.out.println();
        System.out.println(nthNode(l2.head,4).data);
    }
//// alternative aproach with only one traversal
//    Aproach 1;
    public static basics.Node nthNode1(basics.Node head,int n){
        int size=0;
        basics.Node temp=head;
        while (temp!=null){
            size++;
            temp=temp.next;
        }
        int m=size-n+1;
        temp=head;
        for (int i = 1; i < m; i++) {
            temp=temp.next;
        }
        return temp;
    }

    //    Aproach 2;
    public static basics.Node nthNode(basics.Node head, int n) {
        basics.Node slow = head;
        basics.Node fast = head;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
