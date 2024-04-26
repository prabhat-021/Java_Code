public class ReverseInKgroups {
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

    public basics.Node reverseKGroup(basics.Node head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        basics.Node current = head;
        basics.Node prev = null;

        while (true) {
            basics.Node last = prev;
            basics.Node newEnd = current;

//            reverse between left and right
            basics.Node next = current.next;
            int len = length(current);
            // base case if length of list is less than k, no need to reverse
            if (len < k) {
                return head;
            }
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            if (current == null) {
                break;
            }
            prev = newEnd;
        }
        return head;
    }
}
