import java.util.Scanner;

public class countingBits {
    public static int[] countBits(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i / 2] + (i & 1);
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] arr = countBits(n);
        for (int i = 0; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
