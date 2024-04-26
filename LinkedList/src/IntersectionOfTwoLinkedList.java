public class IntersectionOfTwoLinkedList {

//
//    hint1:- find the length of both lists
//    hint2:- increment the bigger list by(m-n)steps
//    m:-length of bigger list
//    n:-length of smaller list
//
    public static void main(String[] args) {
//        basics.linkedList l4=new basics.linkedList();
//        basics.linkedList l5=new basics.linkedList();
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public basics.Node getIntersectionNode(basics.Node headA, basics.Node headB) {
            int size1=size(headA);
            int size2=size(headB);
            basics.Node temp1=headA;
            basics.Node temp2=headB;
            if(size1>size2){
                for(int i=1;i<=(size1-size2);i++){
                    temp1=temp1.next;
                }
            }else{
                for(int i=1;i<=(size2-size1);i++){
                    temp2=temp2.next;
                }
            }
            while(temp1!=temp2){
                temp1=temp1.next;
                temp2=temp2.next;
            }
            return temp1;
        }
        int size(basics.Node head) {
            int count = 0;
            basics.Node temp = head;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }
    }
}
