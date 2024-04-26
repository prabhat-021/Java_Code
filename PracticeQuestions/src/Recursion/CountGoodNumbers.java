package Recursion;

public class CountGoodNumbers {
    public static void main(String[] args) {

    }

    public static long mod = 1000000009;

    public static int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = (n + 1) / 2;

        return (int) ((pow(5, even) * pow(4, odd)) % mod);
    }

    static long pow(long p, long q) {
        if (q == 0) return 1;
        long smallPow = pow(p, q / 2);
        if (q % 2 == 0) {
            return (smallPow * smallPow) % mod;
        }
        return (p * smallPow * smallPow) % mod;
    }
}
