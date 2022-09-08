import java.util.*;

public class BubbleSort {
    public static void bubbleSort(int[] arr, int n) {
        for (int i = n - 1; i > 0; i--) {
            boolean isNotSwpped = true;
            // each iteration we just we just pushing next large number to right side
            for (int j = 0; j < i; j++) {
                // if 1, (4 > 2) , 5 true , do swap
                if (arr[j] > arr[j + 1]) {
                    isNotSwpped = false;
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
            if (isNotSwpped) {
                break;
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
        bubbleSort(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
/*
 * Time Complexity:
 * Best Case : O(N) -> Ascending Order
 * Average Case : O(N^2) -> Random Order
 * Worst Case : O(N^2) -> Decending Order
 */