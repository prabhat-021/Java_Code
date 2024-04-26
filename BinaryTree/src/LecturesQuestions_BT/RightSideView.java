package LecturesQuestions_BT;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public static void main(String[] args) {

    }

    public class Node {
        int val;
        Node left;
        Node right;
    }

    int visited = -1;

    public List<Integer> rightSideView(Node node) {
        List<Integer> ll = new ArrayList<>();
        view(node, 0, ll);
        return ll;
    }

    public void view(Node node, int curr, List<Integer> ll) {
        if (node == null) return;
        if (curr > visited) {
            ll.add(node.val);
            visited = curr;
        }
//        First it will go to right side;
        view(node.right, curr + 1, ll);
//        second it will go to right side;
        view(node.left, curr + 1, ll);
    }
}
