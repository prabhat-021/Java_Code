package Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        generate(n,ans,0,0,"");
        return  ans;
    }

    public void generate(int n,List<String> ans,int open ,int close,String str){
        if(open==n && close==n){
            ans.add(str);
            return;
        }

        if(open<n){
            generate(n,ans,open+1,close,str+"(");
        }
        if(close<open){
            generate(n,ans,open,close+1,str+")");
        }
    }

}
