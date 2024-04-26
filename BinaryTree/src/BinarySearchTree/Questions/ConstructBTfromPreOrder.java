package BinarySearchTree.Questions;

public class ConstructBTfromPreOrder {
    public static void main(String[] args) {

    }

    //    INORDER AND POST ORDER IS GIVEN
//    CONSTRUCT A TREE
    public class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public Node buildTree(int[] preOrder, int[] inOrder) {
        return CreateTree(preOrder, inOrder, 0, inOrder.length - 1, 0, preOrder.length - 1);
    }

    public Node CreateTree(int[] pre, int[] in, int ilo, int ihi, int plo, int phi) {
        Node node = new Node(pre[plo]);
        int idx = search(in, ilo, ihi, pre[plo]);
        int nel = idx - ilo;
        node.left = CreateTree(pre, in, ilo, idx - 1, plo + 1, plo + nel);
        node.right = CreateTree(pre, in, idx + 1, ihi, plo + nel + 1, phi);
        return node;
    }

    public int search(int[] in, int si, int ei, int item) {
        for (int i = si; i < ei; i++) {
            if (in[i] == item) return i;
        }
        return 0;
    }
}
