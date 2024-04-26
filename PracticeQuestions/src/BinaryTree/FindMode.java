package BinaryTree;

import java.util.HashMap;

public class FindMode {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
        TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static void main(String[] args) {

    }

    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        maxCal(root,mp);
        int max=Integer.MIN_VALUE;

        for (Integer val: mp.values()) {
            if(val>max) max=val;
        }

        int size=0;
        for (Integer val :mp.values()) {
            if(val==max) size++;
        }
        int[] ans=new int[size];
        for (Integer val:mp.keySet()) {
            if(mp.get(val)==max) ans[size--]=val;
        }

        return ans;
    }

    public static void maxCal(TreeNode root,HashMap<Integer,Integer> mp){
          if(root==null) return;

          maxCal(root.left,mp);
          maxCal(root.right,mp);
          mp.put(root.val, mp.getOrDefault(root.val,0)+1);
    }


}
