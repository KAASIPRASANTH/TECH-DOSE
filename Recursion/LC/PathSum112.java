package Recursion.LC;

public class PathSum112 {
    boolean result = false;

    public void isTrue(TreeNode root, int target, int currSum) {
        if (result) {
            return;
        }
        currSum += root.val;
        if (root.left == null && root.right == null) {
            if (currSum == target) {
                result = true;
                return;
            } else {
                return;
            }
        }
        if (root.left != null)
            isTrue(root.left, target, currSum);
        if (root.right != null)
            isTrue(root.right, target, currSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        isTrue(root, targetSum, 0);
        return result;
    }

    public static void main(String[] args) {
        /*
         * Input:
         * root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
         * Output: true
         */
    }
}