

import java.util.*;

public class SumofSubarrayMinimums907 {
    public static int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int size = arr.length;
        int[] left = new int[size];
        int[] right = new int[size];
        Arrays.fill(left, -1);
        Arrays.fill(right, size);
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < size; i++) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                left[i] = s.peek();
            }
            s.push(i);
        }
        s.clear();
        for (int i = size - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                right[i] = s.peek();
            }
            s.push(i);
        }
        long res = 0;
        for (int i = 0; i < size; i++) {
            long l = i - left[i];
            long r = right[i] - i;
            res = (res + (arr[i] * l * r) % mod) % mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(sumSubarrayMins(arr));
    }
}
