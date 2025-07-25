package LecturesQuestions_BT;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {

    }

    public class Node {
        int val;
        Node left;
        Node right;
    }

    //    TIME COMPLEXITY
//    T(N)=T(N/2)+T(N/2);
//    T(N)=4T(N/2)+1
//    O(N^2) WILL BE THE ANSWER AFTER SOLVING;

    public int diameterOfTree(Node root) {
        if (root == null) return 0;

        int leftDiameter = diameterOfTree(root.left);
        int rightDiameter = diameterOfTree(root.right);
        int sd = hit(root.right) + hit(root.left);

        return Math.max(leftDiameter, Math.max(rightDiameter, sd));
    }

    public int hit(Node root) {
        if (root == null) return -1;
        int left = hit(root.left);
        int right = hit(root.right);
        return Math.max(left, right) + 1;
    }

    //    BETTER APPROACH
    public class DiaPair {
        int dt = 0;
        int ht = -1;
    }

    public DiaPair diameter(Node node) {
        if (node == null) return new DiaPair();

        DiaPair ldp = diameter(node.left);
        DiaPair rdp = diameter(node.right);
        DiaPair sdp = new DiaPair();
        int sd = ldp.ht + rdp.ht + 2;
        sdp.dt = Math.max(sd, Math.max(ldp.dt, rdp.dt));
        sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;

        return sdp;
    }
}
