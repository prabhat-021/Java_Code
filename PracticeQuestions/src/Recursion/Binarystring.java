package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Binarystring {
    public static void main(String[] args) {

    }

    public static List< String > generateString(int N) {
        List<String> ans=new ArrayList<>();
        generate(N,ans,0,"",false);
        return ans;
    }

    public static void generate(int N,List<String> ans,int idx,String temp,boolean flag){
//        Base case
        if(N==idx){
            ans.add(temp);
            return;
        }
//       Logic
        if(!flag){
            generate(N,ans,idx+1,temp+"0",false);
            generate(N,ans,idx+1,temp+"1",true);
        }else {
            generate(N,ans,idx+1,temp+"0",false);
        }
    }
}
