public class NumberOfSubSetsWithGivenDiff {
    public static int countWithGivenDiff(int arr[], int n, int diff) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }

        if (diff > sum || (sum + diff) % 2 == 1) {
            return 0;
        }
        int s1 = (sum + diff) / 2;
        int[][] dp = new int[n + 1][s1+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s1; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[n][s1];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 2 };
        int diff = 1, n = 5;
        System.out.println(countWithGivenDiff(arr, n, diff));
    }
}