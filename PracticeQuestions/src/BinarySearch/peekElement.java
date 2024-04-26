package BinarySearch;

public class peekElement {
    public static void main(String[] args) {

    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int start = 0, high = n - 1;
        while (start <= high) {
            int mid = (start + high) / 2;
            if (nums[start] < nums[mid]) {
                start = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[start];
    }
}
