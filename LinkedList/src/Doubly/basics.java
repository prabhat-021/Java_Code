package Doubly;

import java.util.Collection;

public class basics {
    public static class Node {
        Node prev;
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node insertAtHead(Node head, int x) {
        Node t = new Node(x);
        t.next = head;
        head.prev = t;
        head = t;
        return head;
    }

    public static Node insertAtTail(Node head, int x) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node t = new Node(x);
        temp.next = t;
        t.prev = temp;
        return head;
    }

    public static Node insertAtIdx(Node head, int idx, int x) {
        Node s = head;
        for (int i = 1; i < idx; i++) {
            s = s.next;
        }
        Node r = s.next;
        Node t = new Node(x);
        s.next = t;
        t.prev = s;
        t.next = r;
        r.prev = t;
        return head;
    }


    public static void main(String[] args) {

    }
}
