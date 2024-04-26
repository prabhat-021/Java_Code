public class MaximunTwinSum {
    public static void main(String[] args) {

    }

//    public int pairSum(ListNode head) {
//        ListNode slow=head;
//        ListNode fast=head;
//        while(fast.next!=null && fast.next.next!=null){
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        ListNode temp=reverseItrative(slow.next);
//        slow.next=temp;
//        ListNode p1=head;
//        ListNode p2=temp;
//        int max=(head.val+temp.val);
//        while(p2!=null){
//            int max2=p1.val+p2.val;
//            if(max2>max) max=max2;
//            p1=p1.next;
//            p2=p2.next;
//        }
//        // while(p2!=null){
//        //     if(p1.val!= p2.val) return false;
//        //     p1=p1.next;
//        //     p2=p2.next;
//        // }
//        return max;
//    }
//
//    public  ListNode reverseItrative(ListNode head){
//        ListNode curr=head;
//        ListNode pre=null;
//        ListNode after=null;
//        while(curr!=null){
//            after=curr.next;
//            curr.next=pre;
//            pre=curr;
//            curr=after;
//        }
//        return pre;
//    }
}
