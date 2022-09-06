import java.util.*;

public class factorsOfN {
    public static List<Integer> allTheFactorsOfN1(int N) {
        List<Integer> al = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                al.add(i);
            }
        }
        return al;
    }

    public static List<Integer> allTheFactorsOfN2(int N) {
        List<Integer> al = new ArrayList<>();
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                al.add(i);
                if ((N / i) != i) {
                    al.add(N / i);
                }
            }
        }
        return al;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        List<Integer> res = new ArrayList<>();
        res = allTheFactorsOfN1(N);
        System.out.println(res);
        res = allTheFactorsOfN2(N);
        System.out.println(res);
    }
}
