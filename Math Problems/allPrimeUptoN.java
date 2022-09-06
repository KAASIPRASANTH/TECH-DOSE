import java.util.*;

public class allPrimeUptoN {
    public static void getAllPrimes1(int N) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            boolean flag = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                res.add(i);
        }
        System.out.println(res);
    }

    public static void getAllPrimes2(int N) {
        List<Integer> res = new ArrayList<>();
        boolean[] prime = new boolean[N + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i <= N; i++) {
            if (prime[i]) {
                res.add(i);
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = false;
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        getAllPrimes1(N);
        getAllPrimes2(N);
        sc.close();
    }
}
