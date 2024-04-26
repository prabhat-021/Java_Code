package Stack.MonotonicStack;

import java.util.ArrayList;
import java.util.Stack;

public class OnlineStockSpan {
    public static void main(String[] args) {

    }


    class StockSpanner {

    Stack<Integer> st;
    ArrayList<Integer> list;
        public StockSpanner() {
            st = new Stack<>();
            list = new ArrayList<>();
        }
        public int next(int price) {
            list.add(price);


               while (!st.isEmpty() && list.get(st.peek()) <= price) {
                st.pop();
            }
            int preGreatIndex = st.isEmpty() ? -1 : st.peek();
            int ans = list.size() - preGreatIndex - 1;

            st.push(list.size() - 1);

            return ans;
        }
    }

}




