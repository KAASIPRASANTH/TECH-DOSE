import java.util.Scanner;

public class MergeSort {
    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low, j = mid + 1, pos = low;
        int[] res = new int[high + 1];
        while (i <= mid && j <= high) {
            if (arr[i] > arr[j]) {
                res[pos++] = arr[j++];
            } else {
                res[pos++] = arr[i++];
            }
        }
        for (; i <= mid; i++) {
            res[pos++] = arr[i];
        }
        for (; j <= high; j++) {
            res[pos++] = arr[j];
        }
        for (i = low; i <= high; i++) {
            arr[i] = res[i];
        }

    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
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
        mergeSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
