package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        String nums="abc";
        List<String>ans=permuteString(nums);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        per(nums,ans,new ArrayList<>());
        return ans;
    }

    public static void per(int[] nums,List<List<Integer>> ans, List<Integer> ll){
        if(ll.size()== nums.length) {
            ans.add(new ArrayList<>(ll));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(ll.contains(nums[i])) continue;
            ll.add(nums[i]);
            per(nums,ans,ll);
            ll.remove(ll.size()-1);
        }
    }

    public static List<String> permuteString(String nums) {
        List<String> ans=new ArrayList<>();
        perString(nums,ans, new StringBuilder(),new ArrayList<>());
        return ans;
    }

    public static void perString(String nums,List<String> ans, StringBuilder ll, List<Character> llas){
        if(ll.length()== nums.length()) {
            ans.add(ll.toString());
            return;
        }

        for (int i = 0; i < nums.length(); i++) {
            char ch=nums.charAt(i);
            if(llas.contains(ch))continue;
            ll.append(ch);
            llas.add(ch);
            perString(nums,ans,ll,llas);
            llas.remove(llas.size()-1);
            ll.deleteCharAt(ll.length()-1);
        }
    }
}
