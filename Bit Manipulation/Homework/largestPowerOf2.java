import java.util.*;

public class largestPowerOf2 {
    public static int getValue(int n) {
        while (n > 0 && (n & (n - 1)) > 0) {
            n = n & (n - 1);
        }
        /*
         * Ex: num = 17
         * 17 & 16 = 16
         * 16 & 15 = 0 now the current vlaue is 16.
         */
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        System.out.println(getValue(num));
    }
}
