import java.util.Scanner;

class PrimeOrNot {
    public static boolean isPrime1(int N) {
        for (int i = 2; i < N; i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime2(int N) {
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        System.out.println(isPrime1(N));
        System.out.println(isPrime2(N));
    }
}