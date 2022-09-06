import java.util.*;

public class subSet {
    public static void getPossibleSubSet(List<List<Integer>> res, int[] arr, int n) {
        for (int i = 0; i < (1 << n); i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    res.get(i).add(arr[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        List<List<Integer>> res = new ArrayList<>();
        getPossibleSubSet(res, arr, n);
        System.out.println(res);
    }
}
