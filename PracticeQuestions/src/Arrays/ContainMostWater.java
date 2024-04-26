package Arrays;

public class ContainMostWater {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxPro = 0;
        while (i < j) {
            int pro = Math.min(height[i], height[j]) * (j - i);
            if (height[i] < height[j]) i++;
            else j--;
            if (pro > maxPro) maxPro = pro;
        }
        return maxPro;
    }
}
