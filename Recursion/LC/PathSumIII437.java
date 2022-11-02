package Recursion.LC;

public class PathSumIII437 {
    static int count;

    public static void solve(TreeNode root, int target, long sum, Map<Long, Integer> map) {
        sum += root.val;
        if (map.containsKey(sum - target)) {
            count += map.get(sum - target);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        } else {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        if (root.left == null && root.right == null) {
            map.put(sum, map.getOrDefault(sum, 0) - 1);
            return;
        }
        if (root.left != null) {
            solve(root.left, target, sum, map);
        }
        if (root.right != null) {
            solve(root.right, target, sum, map);
        }
        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }

    public static int pathSum(TreeNode root, int targetSum) {
        count = 0;
        if (root == null)
            return count;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);
        solve(root, targetSum, 0, map);
        return count;
    }

    public static void main(String[] args) {

    }
}
