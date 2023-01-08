public class MatrixChainMaultiplications {
    // Recursion
    public static int MCM1(int[] matrix, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = l; k < r; k++) {
            int left = MCM1(matrix, l, k);
            int right = MCM1(matrix, k + 1, r);
            int CurrCost = matrix[l - 1] * matrix[k] * matrix[r];
            res = Math.min(res, left + right + CurrCost);
        }
        return res;
    }

    // Tabulation
    public static int MCM2(int[] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int size = 2; size <= n - 1; size++) {
            for (int left = 1; left <= n - size; left++) {
                int right = left + size - 1, res = Integer.MAX_VALUE;
                for (int k = left; k < right; k++) {
                    int cost = matrix[left - 1] * matrix[k] * matrix[right];
                    res = Math.min(res, dp[left][k] + dp[k + 1][right] + cost);
                }
                dp[left][right] = res;
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] matrix = { 4, 2, 3, 1, 3 };
        System.out.println(MCM1(matrix, 1, n - 1));
        System.out.println(MCM2(matrix));
    }
}