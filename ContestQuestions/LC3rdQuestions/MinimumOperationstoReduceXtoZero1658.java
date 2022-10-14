

import java.util.*;

public class MinimumOperationstoReduceXtoZero1658 {
    public static int minOperations(int[] nums, int x) {
        int maxSize = -1, n = nums.length;
        int left = 0, sum = 0;

        int target = 0;
        for (int i = 0; i < n; i++) {
            target += nums[i];
        }
        if (target == x)
            return n;
        target -= x;
        for (int right = 0; right < n;) {
            sum += nums[right++];
            while (sum >= target && left < right) {
                if (sum == target) {
                    maxSize = Math.max(maxSize, right - left);
                }
                sum -= nums[left++];
            }
        }
        return maxSize == -1 ? -1 : n - maxSize;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        sc.close();
        System.out.println(minOperations(nums, x));
    }
}
