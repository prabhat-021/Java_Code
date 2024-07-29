package Heap;

import java.util.PriorityQueue;

public class MergeKSortedList {
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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            while (temp != null) {
                pq.add(temp.val);
                temp = temp.next;
            }
        }

        ListNode head = new ListNode();
        ListNode head1 = head;

        while (!pq.isEmpty()) {
            ListNode temp = new ListNode(pq.poll());
            head1.next = temp;
            head1 = head1.next;
        }

        return head;
    }
}
