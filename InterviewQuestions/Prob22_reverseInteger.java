import java.util.Scanner;

public class Prob22_reverseInteger {
    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return (result>Integer.MAX_VALUE && result<Integer.MIN_VALUE)?0:(int)result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        System.out.println(reverse(num));
    }
}
