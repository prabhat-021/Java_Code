import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {

    }

    int celebrity(int m[][], int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        while (st.size() > 1) {
            int v1 = st.pop();
            int v2 = st.pop();
            if (m[v1][v2] == 0) st.push(v1);
            else if (m[v2][v1] == 0) st.push(v2);
        }
        if (st.size() == 0) return -1;
        int potential = st.pop();
        for (int i = 0; i < n; i++) {
            if (i == potential) continue;
            if (m[i][potential] == 0) return -1;
        }
        for (int i = 0; i < n; i++) {
//            if(i==potential) continue;
            if (m[potential][i] == 1) return -1;
        }
        return potential;
    }
}
