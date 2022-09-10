import java.util.*;

public class RadixSort {
    public static int findMax(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return (max + "").length();
    }

    public static void sortByRadix(int[] arr, int n) {
        int maxPass = findMax(arr, n);
        int pow = 1;
        for (int i = 1; i <= maxPass; i++) {
            List<List<Integer>> res = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                res.add(new ArrayList<>());
            }
            for (int j = 0; j < n; j++) {
                res.get((arr[j] / pow) % 10).add(arr[j]);
            }
            int pos = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < res.get(j).size(); k++) {
                    arr[pos++] = res.get(j).get(k);
                }
            }
            pow *= 10;
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
        sortByRadix(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
