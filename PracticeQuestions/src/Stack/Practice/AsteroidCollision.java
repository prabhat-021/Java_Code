package Stack.Practice;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] arr = {1, -1, -2, -2};
        int[] ans = asteroidCollision(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        st.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if (!st.isEmpty() && st.peek() < 0) {
                st.push(asteroids[i]);
            } else {
                if (asteroids[i] > 0) {
                    st.push(asteroids[i]);
                } else {
                    while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) {
                        st.pop();
                    }
                    if (st.isEmpty() || st.peek() < 0) {
                        st.push(asteroids[i]);
                    } else if (st.peek() == Math.abs(asteroids[i])) {
                        st.pop();
                    }
                }
            }
        }
        int ans[] = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }

    class Solution {
        public int[] asteroidCollision(int[] asteroids) {

            Stack<Integer> st = new Stack<>();
            for(int i =0;i<asteroids.length;i++){
                int a = asteroids[i];
                int fl = 1;//it is flag variable it describes if 1 is there that no collison occurs and 0 means collision ho gaya
                while(!st.isEmpty() && st.peek()>0 && a<0){//it means st mein jo value h voh positive value and a mein jo value h voh negative it meaans 1 positive and 1 value is negative
                    if(Math.abs(a)==st.peek()){
                        fl=0;
                        st.pop();
                        break;
                    }
                    else if(Math.abs(a)>st.peek()){//means negative vali value ko size jada nikal gaya toh hum jo stack ke peek pe value hai usko hata denge
                        st.pop();
                    }
                    else{
                        fl=0;
                        break;//it means agar negative vale asteroid ki value kam hai stack pe jo value hai toh f1=0 kardo aur stack ka asteroid asteroid mein hi rahega
                    }
                }
                if(fl==1){
                    st.push(a);
                }
            }
            //aab jo hamara result hai voh stack mein hoga toh loop lageyge
            int [] result = new int[st.size()];
            for(int i =result.length-1;i>=0;i--){
                result[i]=st.pop();
            }
            return result;
        }
    }
}
