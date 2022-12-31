public class Knapscak {
    public static int KnapsackInRecursion(int[] weight, int[] profit, int capacity, int n) {
        if (capacity == 0 || n == 0) {
            return 0;
        }
        if (capacity < weight[n - 1]) {
            return KnapsackInRecursion(weight, profit, capacity, n - 1);
        }
        int Include = profit[n - 1] + KnapsackInRecursion(weight, profit, capacity - weight[n - 1], n - 1);
        int Exclude = KnapsackInRecursion(weight, profit, capacity, n - 1);
        return Math.max(Include, Exclude);
    }

    public static <till> int KnapsackInDP(int[] weight, int[] profit, int capacity, int n) {
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) { // item =0 || capacity=0 then profit also 0
                    dp[i][j] = 0;
                } else if (j < weight[i - 1]) { 
                    // when ItemWeight > capacity we can't include that item so, Exclude by taking maxProf till now we got
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 2 Choice Include / Exclude
                    // Now we don't know which one will give max profit 
                    // So, Take MAX(Include,Exclude)
                    dp[i][j] = Math.max(dp[i - 1][j], profit[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weight = { 1, 2, 3 };
        int[] profit = { 2, 3, 5 };
        int capacity = 4;
        System.out.println("Recursion " + KnapsackInRecursion(weight, profit, capacity, weight.length));
        System.out.println("Tabulation " + KnapsackInDP(weight, profit, capacity, weight.length));
    }
}