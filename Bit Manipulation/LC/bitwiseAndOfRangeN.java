import java.util.Scanner;

public class bitwiseAndOfRangeN {
    public static int bitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            count++;
        }
        return m <<= count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        System.out.println(bitwiseAnd(m, n));
    }
}
