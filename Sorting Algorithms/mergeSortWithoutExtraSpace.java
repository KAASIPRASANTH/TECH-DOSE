import java.util.*;

public class mergeSortWithoutExtraSpace {
    public static void merge(int[] arr, int low, int mid, int high) {
        if ((high - low) <= 1) {
            int v1 = arr[low], v2 = arr[high];
            arr[low] = Math.min(v1, v2);
            arr[high] = Math.max(v1, v2);
            return;
        }
        for (int i = high; i > mid; i--) {
            int lastEle = arr[mid], j;// arr1 last element
            for (j = mid - 1; j >= low && arr[j] > arr[i]; j--) {
                arr[j + 1] = arr[j];
            }
            if (j == mid - 1 && lastEle > arr[i]) {
                arr[j + 1] = arr[i];
                arr[i] = lastEle;
            }
            if (j != mid - 1 && lastEle > arr[i]) {
                arr[j + 1] = arr[i];
                arr[i] = lastEle;
            }
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
        mergeSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
