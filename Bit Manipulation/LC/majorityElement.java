import java.util.Scanner;

public class majorityElement {
    public static int findMajorityElement(int[] arr, int n) {
        int element = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (element == arr[i]) {
                count++;
            } else {
                count--;
                if (count <= 0) {
                    element = arr[i];
                    count = 1;
                }
            }
        }
        return element;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(findMajorityElement(arr, n));
    }
}
