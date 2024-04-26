import java.util.HashMap;
import java.util.Hashtable;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {

    }

    public static class Node {
        int val;
        Node next;
        Node random;

        Node(int value) {
            val = value;
            next = null;
            random = null;
        }
    }

//    BRUTE FORCE APPPROACH
//    TIME COMPLEXICITY=O(N)+O(N);
//    SPACE COMPLEXICITY=O(N);
//
//    public Node copyRandomList(Node head) {
//        HashMap<Node, Node> mp = new HashMap<>();
//        Node temp = head;
//
//        while (temp != null) {
//            Node newNode = new Node(temp.val);
//            mp.put(temp, newNode);
//            temp = temp.next;
//        }
//
//        Node temp2 = head;
//
//        while (temp2 != null) {
//            Node node = mp.get(temp2);
//            node.next = (temp2.next != null) ? mp.get(temp2.next) : null;
//            node.random = (temp2.random != null) ? mp.get(temp2.next) : null;
//            temp2 = temp2.next;
//        }
//
//        return mp.get(head);
//    }

    public Node copyRandomList(Node head) {
        Node iter = head;
        Node front = head;

//        STEP:1
        while (iter != null) {
            front = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }
//        STEP:2
        iter = head;
        while (iter != null) {
            if (iter.random != null) iter.next.random = iter.random.next;
            iter = iter.next.next;
        }
//        STEP:3
        iter = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        while (iter != null) {
            front = iter.next.next;
            copy.next = iter.next;
            iter.next = front;
            copy = copy.next;
            iter = front;
        }
        return dummy.next;
    }
}
