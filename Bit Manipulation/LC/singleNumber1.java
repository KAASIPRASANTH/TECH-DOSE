import java.util.*;

public class singleNumber1 {
    public static int findSingleOne(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(findSingleOne(arr, n));
    }
}