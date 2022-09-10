import java.util.*;

public class bucketSort {
    public static void sortByBuckets(int[] arr, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        // finding maxEle to make a list
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        // creating buckets
        for (int i = 0; i <= max; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            res.get(arr[i]).add(arr[i]);
        }
        int pos = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                arr[pos++] = res.get(i).get(j);
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
        sortByBuckets(arr, n);
        sc.close();
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}