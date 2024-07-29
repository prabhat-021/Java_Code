package BinaryTree.BST;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder);

        int i = 0, j = inorder.size() - 1;

        while (i < j) {
            if (inorder.get(i) + inorder.get(j) == k) return true;
            else if (inorder.get(i) + inorder.get(j) > k) j--;
            else i++;
        }
        return false;
    }

    private List<Integer> inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return new ArrayList<>();
        inOrder(node.left, list);
//        System.out.println(node.val + " ");
        list.add(node.val);
        inOrder(node.right, list);
        return list;
    }
}
