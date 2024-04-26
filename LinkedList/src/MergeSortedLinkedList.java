import org.w3c.dom.Node;

public class MergeSortedLinkedList {
    public static void main(String[] args) {}
//
//    Approach 1:-
//With extra spaces
//

    public basics.Node mergeTwoLists(basics.Node list1, basics.Node list2) {
        basics.Node temp1=list1;
        basics.Node temp2=list2;
        basics.Node head=new basics.Node(100);
        basics.Node temp=head;
        while(temp1!=null && temp2!=null){
            if(temp1.data< temp2.data){
                basics.Node a=new basics.Node(temp1.data);
                temp.next=a;
                temp=a;
                temp1=temp1.next;
            }else{
                basics.Node a=new basics.Node(temp2.data);
                temp.next=a;
                temp=a;
                temp2=temp2.next;
            }
        }
        if(temp1==null){
            temp.next=temp2;
        }else {
            temp.next=temp1;
        }
        return head.next;
    }
//
//    Approach 2:-
//Without extra spaces
//
    public basics.Node mergeTwoListsWithoutExtraspace(basics.Node list1, basics.Node list2){
        basics.Node head=new basics.Node(100);
        basics.Node temp=head;
        while(list1!=null && list2!=null){
            if(list1.data<list2.data){
                temp.next=list1;
                temp=list1;
                list1=list1.next;
            }else {
                temp.next=list2;
                temp=list2;
                list2=list2.next;
            }
        }
        if(list1==null){
            temp.next=list2;
        }else {
            temp.next=list1;
        }
        return head.next;
    }
}
