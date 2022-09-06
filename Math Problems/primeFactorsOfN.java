import java.util.*;

public class primeFactorsOfN {
    public static void allPrimefactors1(int N) {
        List<Integer> al = new ArrayList<>();
        for (int i = 2; i < N; i++) {
            boolean flag = true;
            // finding i is prime or not
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag && N % i == 0) {
                // i is prime & it's factor of N
                al.add(i);
            }
        }
        System.out.println(al);
    }

    public static void allPrimefactors2(int N) {
        int x = N;
        List<Integer> al = new ArrayList<>();
        for (int i = 2; i * i <= N; i++) {
            while (x % i == 0) {
                x /= i;
                if (!al.contains(i)) {
                    al.add(i);
                }
            }
        }
        if (x > 2) {
            al.add(x);
        }
        System.out.println(al);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        // List<Integer> res = new ArrayList<>();
        allPrimefactors1(N);
        allPrimefactors2(N);
    }
}
