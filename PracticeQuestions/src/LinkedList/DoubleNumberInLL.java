package LinkedList;

public class DoubleNumberInLL {
    public static void main(String[] args) {

    }

    public RemoveNode.Node doubleIt(RemoveNode.Node head) {
        int sum=0;
        RemoveNode.Node temp=head;
        sum= doubleSum(temp,sum);
       if(sum>0){
           RemoveNode.Node ll=new RemoveNode.Node(sum);
           ll.next=head;
           head=ll;
       }
        return head;
    }

    public int doubleSum(RemoveNode.Node temp,int sum){
        int ran = temp.val;
        if (temp.next == null) {
            temp.val = (2 * ran) % 10;
            sum = (2 * ran) / 10;
            return sum;
        }

        temp.val = doubleSum(temp.next, sum) + (2 * ran) % 10;

        return (2 * ran) / 10;

    }
}
