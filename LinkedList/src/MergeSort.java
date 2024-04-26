public class MergeSort {
    public static void main(String[] args) {
basics.linkedList ll = new basics.linkedList();
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        ll.insertAtEnd(6);
//        ll.display();
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        ll.insertAtEnd(6);
        ll.insertAtBeginning(44);
        ll.insertAtBeginning(55);
        ll.insertAtIndex(3, 66);
        ll.insertAtIndex(3, 67);
        ll.display();
        System.out.println("list after sorting");
        sortList(ll.head);
        ll.display();
    }

//    public  static class basics.basics.basics.Node {
//        int data;
//        basics.basics.basics.Node next;
//
//        basics.basics.basics.Node() {
//        }
//
//        basics.basics.basics.Node(int data) {
//            this.data = data;
//        }
//
//        basics.basics.basics.Node(int data, basics.basics.basics.Node next) {
//            this.data = data;
//            this.next = next;
//        }
//    }

    public static basics.Node sortList(basics.Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        basics.Node mid = getmid(head);
        basics.Node left = sortList(head);
        basics.Node right = sortList(mid);

        return merge(left, right);
    }

    static basics.Node merge(basics.Node list1, basics.Node list2) {
        basics.Node nhead = new basics.Node(1);
        basics.Node tail = nhead;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return nhead.next;
    }

    static  basics.Node getmid(basics.Node head) {
        basics.Node temp = null;
        while (head != null && head.next != null) {
            temp = (temp == null) ? head : temp.next;
            head = head.next.next;
        }
        basics.Node mid=temp.next;
        temp.next=null;
        return mid;
    }

}
