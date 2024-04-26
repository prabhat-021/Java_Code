
public class basics {
    public static class Node {
        int data;
        Node next;

        Node() {

        }

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static class linkedList {
        Node head = null;
        Node tail = null;

        void insertAtEnd(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = temp;
            } else {
                tail.next = temp;
            }
            tail = temp;
        }

        void insertAtBeginning(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                temp.next = head;
                head = temp;
            }
        }

        void insertAtIndex(int idx, int val) {
            Node t = new Node(val);
            Node temp = head;
            if (idx == size()) {
                insertAtEnd(val);
                return;
            } else if (idx == 0) {
                insertAtBeginning(val);
                return;
            } else if (idx > size() || idx < 0) {
                System.out.println("Wrong index");
            }
            for (int i = 1; i < idx; i++) {
                temp = temp.next;
            }
            t.next = temp.next;
            temp.next = t;
        }

//        Insertion Using Recursion

        int getElement(int idx) {
            if (idx > size() || idx < 0) {
                System.out.println("Wrong index");
                return -1;
            }
            Node temp = head;
            for (int i = 1; i < idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

        void deleteAtIndex(int idx) {
            if (idx > size() || idx < 0) {
                System.out.println("Wrong index");
                return;
            }
            if (idx == 0) {
                head = head.next;
            }
            Node temp = head;
            for (int i = 1; i < idx; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (idx == size()) tail = temp;

        }

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

        int size() {
            int count = 0;
            Node temp = head;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        ll.insertAtEnd(6);
//        ll.display();
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        ll.insertAtEnd(6);
        ll.insertAtBeginning(44);
        ll.insertAtBeginning(55);
        ll.insertAtIndex(3, 66);
        ll.insertAtIndex(3, 67);
        ll.display();
        System.out.println();
        ll.deleteAtIndex(3);
        ll.display();
        System.out.println("\n" + ll.size() + ":-Size of ll");
        System.out.println(ll.getElement(4));
        ;
    }
}
