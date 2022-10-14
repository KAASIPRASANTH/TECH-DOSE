import java.util.*;

public class ConcatenationofConsecutiveBinaryNumbers1680 {
    public static int concatenatedBinary(int n) {
        int mod = 1000000007;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            int numOfBits = 1 + (int) (Math.log(i) / Math.log(2));
            res = (((res << numOfBits) % mod) + i) % mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(concatenatedBinary(n));
    }
}
