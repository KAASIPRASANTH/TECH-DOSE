import java.util.Scanner;

public class binomialCoeff {
    public static int comb(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        // Pascal triangle concept
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else if (i == j)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        System.out.println(comb(n, k));
        ;
    }
}
