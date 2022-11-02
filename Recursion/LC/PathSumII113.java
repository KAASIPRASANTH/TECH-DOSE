package Recursion.LC;
import java.util.*;
public class PathSumII113 {
    static List<List<Integer>> res;

    public static void solve(TreeNode root, int target, int currSum, List<Integer> temp) {
        currSum += root.val;
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == target) {
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            } else {
                temp.remove(temp.size() - 1);
                return;
            }
        }
        if (root.left != null) {
            solve(root.left, target, currSum, temp);
        }
        if (root.right != null) {
            solve(root.right, target, currSum, temp);
        }
        temp.remove(temp.size() - 1);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if (root == null){
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        solve(root, targetSum, 0, temp);
        return res;
    }

    public static void main(String[] args) {
        /*
         * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
         * Output: [[5,4,11,2],[5,8,4,5]]
         */
    }
}