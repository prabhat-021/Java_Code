package LecturesQuestions_BT;

public class FlipEquivalentBinarTree {
    public static void main(String[] args) {

    }

    public class Node {
        int val;
        Node left;
        Node right;
    }

    public boolean isFlipPossible(Node node1, Node node2) {
        return Eqvi(node1, node2);
    }

    public boolean Eqvi(Node node1, Node node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
//        this will check that the value is same or not
        if (node1.val != node2.val) return false;
//        this will check whether the tree is mirror or not
        boolean flip = Eqvi(node1.left, node2.right) && Eqvi(node1.right, node2.left);
//        this will check that tree is exactly same or not ;
        boolean noFlip = Eqvi(node1.right, node2.right) && Eqvi(node1.left, node2.left);
//        If either of one is true than it is true as either it is mirror or either it is flip ;
        return flip || noFlip;
    }

}
