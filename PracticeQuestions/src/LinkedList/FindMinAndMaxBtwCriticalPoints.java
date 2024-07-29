package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindMinAndMaxBtwCriticalPoints {
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

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        List<Integer> ll = new ArrayList<>();

        ListNode prev = head;
        ListNode temp = head.next;
        int counter = 2;
        int mindis = Integer.MAX_VALUE;
        int preCouter = counter;
        while (temp.next != null) {
            if ((prev.val > temp.val && temp.val < temp.next.val)
                    || (prev.val < temp.val && temp.val > temp.next.val)) {
                ll.add(counter);
                if (ll.size() > 1)
                    mindis = Math.min(mindis, counter - preCouter);
                preCouter = counter;
            }

            prev = temp;
            temp = temp.next;
            counter++;
        }

        if (ll.size() < 2) {
            return new int[]{-1, -1};
        }
        ans[1] = ll.get(ll.size() - 1) - ll.get(0);
        ans[0] = mindis;
        return ans;
    }

}
