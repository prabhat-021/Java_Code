public class DivideTwoInteger {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648,1));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;

        boolean sign = true;

        if ((dividend >= 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = false;

        long divd = Math.abs((long) dividend);
        long dis = Math.abs((long)divisor);

        long ans = 0;

        while (divd >= dis) {
            int count = 0;
            while (divd >= (dis << count + 1)) {
                count++;
            }
            ans += (1L << count);
            divd = divd - dis * (1L << count);
        }

        if (!sign) ans = -ans;

        if (ans >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) ans;
    }
}
