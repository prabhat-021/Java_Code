public class OddEvenLinkedList {
    public static void main(String[] args) {

    }

    public basics.Node oddEvenList(basics.Node head) {
        basics.Node odd=new basics.Node(0);
        basics.Node even=new basics.Node(0);
        basics.Node tempo=odd;
        basics.Node tempe=even;
        basics.Node temp=head;

        while(temp!=null){
            tempo.next=temp;
            temp=temp.next;
            tempo=tempo.next;

            tempe.next=temp;
            if(temp==null) break;
            temp=temp.next;
            tempe=tempe.next;
        }
        odd=odd.next;
        even=even.next;
        tempo.next=even;

        return odd;
    }
}
