import java.util.*;

public class Prob86_CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i] <= j) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] > amount)
            return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(coinChange(coins, amount));
    }
}
