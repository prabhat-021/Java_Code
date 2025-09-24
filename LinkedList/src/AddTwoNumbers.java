public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode dummy = new ListNode(0);
        int carry = 0;

        while (t1 != null || t2 != null || carry == 1) {
            int sum = 0;
            if (t1 != null) {
                sum += t1.val;
                t1 = t1.next;
            }
            if (t2 != null) {
                sum += t2.val;
                t2 = t2.next;
            }
            sum += carry;
            ListNode Node = new ListNode(sum % 10);
            carry = sum / 10;
            dummy.next = Node;
            dummy = dummy.next;
        }

        return dummy.next;
    }
}
