package Self_Balancing_Tree.SegmentTree;
//
//    O(N) is not good enough find O(logN) solution;
//    Answer ---> Segement Tree
//
//            Segment --> perform gquesry on a range
//    like--> (sum,max,avg,min,product)in range;
//    in O(logN) time
//    update O(logN);
//

public class SegmentTree {
    public static void main(String[] args) {

    }

    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.endInterval = endInterval;
            this.startInterval = startInterval;
        }
    }

    private Node root;

    public SegmentTree(int[] arr) {
        this.root = CreateTree(arr, 0, arr.length - 1);
    }

    private Node CreateTree(int[] arr, int start, int end) {
        if (start == end) {
//           LEAF NODE
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
//       CREATE NEW NODE WITH INDEX YOU ARE AT
        Node node = new Node(start, end);

        int mid = (start + end) / 2;
        node.left = this.CreateTree(arr, start, mid);
        node.right = this.CreateTree(arr, mid + 1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data;
//            NODE IS COMPLETELY LYING INSIDE QUESRY
        } else if (node.startInterval > qei || node.endInterval < qei) {
//            COMPLETELY OUTSIDE
            return 0;
        } else {
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);

                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }

}
