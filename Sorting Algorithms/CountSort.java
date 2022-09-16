import java.util.*;

public class CountSort {
    public static int findRange(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max + 1;
    }

    public static int[] sortByCount(int[] arr, int n) {
        int size = findRange(arr, n);
        int[] count = new int[size];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < size; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int pos = --count[arr[i]];
            res[pos] = arr[i];
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
        arr = sortByCount(arr, n);
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
