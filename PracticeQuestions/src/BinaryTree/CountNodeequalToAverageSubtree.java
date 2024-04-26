package BinaryTree;

public class CountNodeequalToAverageSubtree {
    public static void main(String[] args) {

    }

    public int averageOfSubtree(FindMode.TreeNode root) {
        average(root);
        return ans;
    }

    public class DiaPair {
        int sum = 0;
        int size = 0;

//        int ans = 0;

        DiaPair() {

        }

        DiaPair(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }

    int ans = 0;

    public DiaPair average(FindMode.TreeNode root) {
        if (root == null) return new DiaPair(0, 0);

        DiaPair countLeft = average(root.left);
        DiaPair countRight = average(root.right);
        DiaPair ans1 = new DiaPair();
        ans1.sum = countRight.sum + countLeft.sum + root.val;
        ans1.size = countRight.size + countLeft.size + 1;
        int avg = ans1.sum / ans1.size;
        if (root.val == avg) ++ans;
        return ans1;
    }
}
