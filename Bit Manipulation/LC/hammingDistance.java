import java.util.Scanner;

public class hammingDistance {
    public static int countOfDifferentBits(int x, int y) {
        int res = x ^ y, count = 0;
        while (res != 0) {
            res = res & (res - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        System.out.println(countOfDifferentBits(x, y));

    }
}