public class RotateList {
    public static void main(String[] args) {

    }

    public int length(basics.Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public basics.Node rotateRight(basics.Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        basics.Node temp1 = head;
        basics.Node temp2 = head;
        for (int i = 0; i < k; i++) {
            temp2 = temp2.next;
        }
        while (temp2.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp2.next=head;
        head=temp1.next;
        temp1.next=null;
        return head;
    }

}
