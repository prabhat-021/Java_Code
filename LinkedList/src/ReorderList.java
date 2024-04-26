public class ReorderList {
    public static void main(String[] args) {

    }

    public void reorderList(basics.Node head) {
        if(head==null || head.next==null) return;
        basics.Node temp1=head;
        basics.Node temp2=head;
        while(temp2.next!=null){
            temp2=temp2.next;
        }
        while(temp1!=temp2){
            temp2.next=temp1.next;
            temp1.next=temp2;
            while(temp2.next!=temp1.next){
                temp2=temp2.next;
            }
            temp1=temp1.next.next;
        }
        temp1.next=null;
    }
}
