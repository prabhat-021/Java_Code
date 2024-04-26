public class deleteDuplicates {
    public static void main(String[] args) {

    }

    public basics.Node deleteDuplicates(basics.Node head) {
        basics.Node temp=head;
        while(temp!=null && temp.next!=null){
            if(temp.data==temp.next.data){
                temp.next=temp.next.next;
            }else {
                // temp.next=temp.next.next;
                temp=temp.next;
            }
        }
        return head;
    }

//    public basics.Node deleteDuplicates2(basics.Node head){
//
//    }
}
