import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInEachWindow {
    public static void main(String[] args) {

    }

    public long[] printFirstNegativeInteger(long A[], int N, int k) {
        long[] res = new long[N - k + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (A[i] < 0) {
                q.add(i);
            }
        }
        int j = 0;
        for (int i = 0; i < N - k + 1; i++) {
            if (q.size() > 0 && q.peek() < i) q.remove();
            if (q.peek() <= i + k - 1) res[i] = q.peek();
            else if (q.peek() == 0) {
                res[i] = 0;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }
}
