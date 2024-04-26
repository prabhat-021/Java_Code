public class alternateSumSeries {
    public static void main(String[] args) {
        System.out.println(seriesSum(5));
    }

    static int seriesSum(int n){
        if(n==0){
            return 0;
        }
        if(n%2==0){
            return seriesSum(n-1)-n;
        }
        return seriesSum(n-1)+n;
    }
}
