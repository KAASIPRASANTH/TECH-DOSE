import java.util.*;

public class findApowerB {
    public static int findPow1(int a, int b) {
        int res = 1;
        for (int i = 1; i <= b; i++) {
            res = res * a;
        }
        return res;
    }

    public static int findPow2(int a, int b) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a;
            }
            a = a * a;
            b /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(findPow1(a, b));
        System.out.println(findPow2(a, b));
        sc.close();
    }
}
