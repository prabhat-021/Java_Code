package LinkedList;

public class MergeNodesBetweenZeros {
    public static void main(String[] args) {

    }

    public RemoveNode.Node mergeNodes(RemoveNode.Node head) {

        RemoveNode.Node temp1 = head.next.next;
        RemoveNode.Node newNode = new RemoveNode.Node();
        head = newNode;

        int counter = 0;
        while (temp1 != null) {
            if (temp1.val == 0) {

                RemoveNode.Node dummy = new RemoveNode.Node(counter);
                newNode.next = dummy;
                newNode = newNode.next;
//               newNode.val=counter;
                counter = 0;
            } else {
                counter += temp1.val;
            }
            temp1 = temp1.next;
        }

        return head.next;
    }
}
