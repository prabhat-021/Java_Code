public class magicNumber {
    public static void main(String[] args) {
        int n = 4;
        int base = 5;
        int ans = 0;
        while (n > 0) {
            int last = n & 1;
            n = n >> 1;
            ans += last * base;
            base = base * 5;
        }
        System.out.println(ans);
    }
}
