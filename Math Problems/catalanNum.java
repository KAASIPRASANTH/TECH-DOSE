import java.util.*;

public class catalanNum {
    public static int getNthCatalanNum1(int[] sequence, int n) {
        if (n == 0 || n == 1) { // for 1st two numbers 1 1 2 5 14 42 .. .. ..
            return 1;
        }
        if (sequence[n] > 0) { // If that value already calculated
            return sequence[n];
        }
        for (int i = 0; i < n; i++) {
            sequence[n] += (getNthCatalanNum1(sequence, i) * getNthCatalanNum1(sequence, n - i - 1));
        }
        return sequence[n];
    }

    public static int getNthCatalanNum2(int[] sequence, int n) {
        sequence[0] = 1;
        if (n >= 1)
            sequence[1] = 1;
        for (int i = 2; i <= n; i++) {
            sequence[i] = 0;
            for (int j = 0; j < i; j++) {
                sequence[i] += (sequence[j] * sequence[i - j - 1]);// 2=> (c0*c1 + c1*c0)
            }
        }
        return sequence[n];
    }

    public static int getNthCatalanNum3(int n) {
        int[][] biCoeff = new int[2 * n + 1][n + 1]; // finding 2nCn
        for (int i = 0; i <= 2 * n; i++) {
            for (int j = 0; j <= Math.min(i, n); j++) {
                if (i == 0 || j == 0)
                    biCoeff[i][j] = 1;
                else
                    biCoeff[i][j] = biCoeff[i - 1][j] + biCoeff[i - 1][j - 1];
            }
        }
        // 2nCn / n+1
        return biCoeff[2 * n][n] / (n + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getNthCatalanNum1(new int[n], n - 1));
        System.out.println(getNthCatalanNum2(new int[n], n - 1));
        System.out.println(getNthCatalanNum3(n - 1));
        sc.close();
    }
}