package PracticeProblems;

public class MaximumPointsCards {
    public static void main(String[] args) {
        int[] arr = {11, 49, 100, 20, 86, 29, 72};
        int k = 4;
        System.out.println(maxScore(arr, k));
    }

//    public static int maxScore(int[] cardPoints, int k) {
//        int sum = 0;
//        for (int i = 0; i < k; i++) {
//            sum += cardPoints[i];
//        }
//        int sum2 = sum;
//        for (int i = 0; i < k; i++) {
//            sum2 -= cardPoints[k - i-1];
//            sum2 += cardPoints[cardPoints.length - i - 1];
//            sum = Math.max(sum, sum2);
//        }
//        return sum;
//    }
//
//    PASSED THE TEST CASE BUT LAST TEST CASE GIVE TLE!!!!
//
    public static int maxScore(int[] cardPoints, int k) {
        int i=0,n=cardPoints.length,ans=0;
        if (k == cardPoints.length) return sumOfArray(cardPoints, 0, k);
        for (int l = 0; l <=k; l++) {
            int left=sumOfArray(cardPoints,0,k-l);
            int right=sumOfArray(cardPoints,n-l,l);
            ans=Math.max(ans,left+right);
        }
        return ans;
    }

//    public static int maxScore(int[] cardPoints, int k) {
//        int i = 0, j = cardPoints.length - 1, ans = 0;
//        for (int l = 0; l < k; l++) {
//            if (cardPoints[i] > cardPoints[j]) ans += cardPoints[i++];
//            else ans += cardPoints[j--];
//        }
//        return ans;
//    }

//    public static int maxScore(int[] cardPoints, int k) {
//        if (k == cardPoints.length) return sumOfArray(cardPoints, 0, k);
//        int left = sumOfArray(cardPoints, 0, k);
//        int right = sumOfArray(cardPoints, cardPoints.length - k, k);
//        return Math.max(left, right);
//    }
//
    static int sumOfArray(int[] arr, int index, int k) {
        int sum = 0;
        for (int i = index; i < (k + index); i++) {
            sum += arr[i];
        }
        return sum;
    }
}
