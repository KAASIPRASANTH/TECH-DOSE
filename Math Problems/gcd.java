import java.util.Scanner;

public class gcd {
    // Euclid's algorithm
    public static int getGcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return getGcd(b % a, a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        System.out.println(getGcd(a, b));
    }
}
