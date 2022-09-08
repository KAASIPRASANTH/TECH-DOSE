import java.util.Scanner;

public class sortWithoutExtraSpace {
    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        for (int i = n - 1; i >= 0; i--) {
            // we just going to place this i-th ele
            // for that we need 1 extra space in arr1
            // we know arr1 is fixed size so, we should right shift all the elements
            // from (j+1)-----> (j) --place for i-- (j+1)
            int lastEle = arr1[m - 1], j;
            for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--) {
                arr1[j + 1] = arr1[j];
            }
            if (j == m - 2 && lastEle > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = lastEle;
            } else if (j != m - 2 && lastEle > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = lastEle;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        sc.close();
        merge(arr1, m, arr2, n);
        for (int i = 0; i < m; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
