package Stack.MonotonicStack;

public class TrapRainWater {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] sufixMax = new int[n];
        int ans = 0;

        prefixMax[0] = height[0];
        sufixMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
            sufixMax[n - i - 1] = Math.max(sufixMax[n - i], height[n - i - 1]);
        }

        for (int i = 0; i < n; i++) {
            int leftMax = prefixMax[i], rightMax = sufixMax[i];
//            if (height[i] < leftMax && height[i] < rightMax) {
            ans += Math.min(leftMax, rightMax) - height[i];
//            }
        }
        return ans;
    }

    public int trapOptimal(int[] height) {
        int n = height.length;
        int lmax = 0, rmax = 0, total = 0, l = 0, r = n - 1;

        while (l < r) {
            if (height[l] < height[r]) {
                if (lmax > height[l]) {
                    total += lmax - height[l];
                } else {
                    lmax = height[l];
                }
                l++;
            } else {
                if (rmax > height[r]) {
                    total += rmax - height[r];
                } else {
                    rmax = height[r];
                }
                r--;
            }
        }
        return total;
    }
}
