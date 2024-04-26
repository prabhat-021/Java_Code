package Hashset;

import java.util.HashSet;

public class basics {
    public static void main(String[] args) {
        HashSet<Integer> st=new HashSet<>();
        st.add(1);
        st.add(2);
        st.add(3);
        st.add(1);
        System.out.println(st);
        System.out.println(st.contains(3));
        st.remove(2);
        for (Integer s: st) {
            System.out.println(s);
        }
    }
}
