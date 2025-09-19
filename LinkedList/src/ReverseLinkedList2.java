public class ReverseLinkedList2 {
    public static void main(String[] args) {

    }

    public basics.Node reverseBetween(basics.Node head, int left, int right) {
        if(head==null || head.next==null || left==right){
            return head;
        }
        basics.Node temp=head;
        basics.Node temp1=null;
        basics.Node temp2=head;
        for (int i = 0;i < left-1; i++) {
            temp1=temp;
            temp=temp.next;
        }
        for (int i = 0; i < right; i++) {
            temp2=temp2.next;
        }
        basics.Node r=reverseItrative(temp,right,left);
        if(head.next==null){
            head=r;
        }else{
            temp1.next=r;
        }
        // temp1.next=r;
        while (r.next!=null){
            r=r.next;
        }
        r.next=temp2;
        return head;
    }

    public static basics.Node reverseItrative(basics.Node head,int right,int left){
        basics.Node curr=head;
        basics.Node pre=null;
        basics.Node after=null;
        for (int i = 0; i <=Math.abs(left-right) ; i++) {
            after=curr.next;
            curr.next=pre;
            pre=curr;
            curr=after;
        }
        return pre;
    }
}
