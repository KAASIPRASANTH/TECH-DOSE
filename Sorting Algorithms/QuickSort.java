import java.util.*;

public class QuickSort {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low], i = low, j = high, temp;
        do {
            do {
                i++;
            } while (arr[i] <= pivot);// it will point always greater than the pivot element
            do {
                j--;
            } while (arr[j] > pivot);// it will point equal or lesser element
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } while (i < j);
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int j = partition(arr, low, high);
            quickSort(arr, low, j);
            quickSort(arr, j + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n++;
        int[] arr = new int[n];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
        }
        arr[n - 1] = Integer.MAX_VALUE;
        sc.close();
        quickSort(arr, 0, n - 1);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
