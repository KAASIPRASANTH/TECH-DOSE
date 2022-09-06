import java.util.Scanner;

public class singleNumber2 {
    public static int findSingleOne(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            int counter = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((arr[j] & (1 << i)) > 0) {
                    counter++;
                }
            }
            if (counter % 3 > 0) {
                res += (1 << i);
            }
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
