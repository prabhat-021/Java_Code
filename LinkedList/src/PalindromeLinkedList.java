public class PalindromeLinkedList {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(basics.Node head){
        basics.Node slow=head;
        basics.Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        basics.Node temp=ReverseLinkedList.reverseLinkedList(slow.next);
        slow.next=temp;
        basics.Node p1=head;
        basics.Node p2=temp;
        while(p2!=null){
            if(p1.data!= p2.data) return false;
            p1=p1.next;
            p2=p2.next;
        }
        return true;
    }
}
