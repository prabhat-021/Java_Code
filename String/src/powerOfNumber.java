public class powerOfNumber {
    public static void main(String[] args) {

    }

    static double pow(double p, int q) {
        if (q == 0) return 1;
        double smallPow = pow(p, q / 2);
        if(q%2==0){
            return smallPow*smallPow;
        }
        return p*smallPow*smallPow;
    }
}