import java.util.*;

public class FiboByBinaryExpo {
    public static int[][] multiply(int[][] res, int[][] arr) {
        int[][] temp = new int[2][2];
        temp[0][0] = res[0][0] * arr[0][0] + res[0][1] * arr[1][0];
        temp[0][1] = res[0][0] * arr[0][1] + res[0][1] * arr[1][1];
        temp[1][0] = res[1][0] * arr[0][0] + res[1][1] * arr[1][0];
        temp[1][1] = res[1][0] * arr[0][1] + res[1][1] * arr[1][1];
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("0");
        } else if (n == 1 || n == 2) {
            System.out.println("1");
        } else {
            int[][] prev = { { 1, 1 }, { 1, 0 } };
            int[][] res = { { 1, 1 }, { 1, 0 } };
            for (int i = 2; i < n; i++) {
                res = multiply(res, prev);
            }
            System.out.println(res[0][0]);
        }
        sc.close();
    }
}
