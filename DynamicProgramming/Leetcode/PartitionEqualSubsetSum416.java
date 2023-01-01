public class PartitionEqualSubsetSum416 {
    public static boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int val : nums) {
            sum += val;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0 && j > 0)
                    dp[i][j] = false;
                else if (i > 0 && j == 0)
                    dp[i][j] = true;
                else if (nums[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 11, 5 };
        System.out.println(canPartition(nums));
    }
}