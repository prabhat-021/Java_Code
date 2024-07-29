package Stack.MonotonicStack;

public class TrapRainWater {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int n = height.length;
        int[] prefixSum = new int[n];
        int[] sufixSum = new int[n];
        int ans = 0;

        prefixSum[0] = height[0];
        sufixSum[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1], height[i]);
            sufixSum[n - i - 1] = Math.max(sufixSum[n - i], height[n - i - 1]);
        }

        for (int i = 0; i < n; i++) {
            int leftMax = prefixSum[i], rightMax = sufixSum[i];
            if (height[i] < leftMax && height[i] < rightMax) {
                ans += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return ans;
    }
}
