

import java.util.*;

public class SubarrayProductLessThanK713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0, cnt = 0, product = 1, n = nums.length;
        while (right < n) {
            product *= nums[right++];
            while (product >= k && left < right) {
                product /= nums[left++];
            }
            cnt += (right - left);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        System.out.println(numSubarrayProductLessThanK(nums,k));
    }
}
