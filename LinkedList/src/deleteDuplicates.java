public class deleteDuplicates {
    public static void main(String[] args) {
        basics.linkedList ll = new basics.linkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(2);
//        ll.insertAtEnd(3);
//        ll.insertAtEnd(4);
//        ll.insertAtEnd(4);
//        ll.insertAtEnd(5);
//        ll.insertAtEnd(6);
        basics.Node a = deleteDuplicates2(ll.head);
        while (a != null) {
            System.out.println(a.data);
            a = a.next;
        }
    }

    public basics.Node deleteDuplicates(basics.Node head) {
        basics.Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                // temp.next=temp.next.next;
                temp = temp.next;
            }
        }
        return head;
    }

    public static basics.Node deleteDuplicates2(basics.Node head) {
        basics.Node temp1 = new basics.Node(0);
        basics.Node temp1p = temp1;
        basics.Node temp = head;


        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                while (temp.next != null && temp.data == temp.next.data) temp = temp.next;
                temp = temp.next;
            } else {
                temp1p.next = temp;
                temp1p = temp1p.next;
                temp = temp.next;
            }
        }
        temp1p.next = temp;

        head = temp1.next;

        return head;
    }
}
