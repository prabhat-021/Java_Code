package Stack.MonotonicStack;

public class SumOfTotalStrengthWizards {
    public static void main(String[] args) {

    }

    public int totalStrength(int[] nums) {
        int ans=0;
        int mod=1000000007;
        for (int i = 0; i < nums.length; i++) {
            int sum=0,min= nums[i];
            for (int j = i; j < nums.length; j++) {
//                max=Math.max(max,nums[j]);
                sum+=nums[j];
                min=Math.min(min,nums[j]);
                ans+=(min*sum)%mod;
            }
        }
        return ans%mod;
    }
}
