import java.util.*;

public class largestSubarraySumAtmostK {
    public static int largestSubarray(int[] nums, int n, int k) {
        int maxSize = 0, left = 0, right = 0, sum = 0;
        for (; right < n; right++) {
            sum += nums[right];
            if (sum > k) {
                sum -= nums[left++];
            }
            maxSize = Math.max(right - left + 1, maxSize);
        }
        return maxSize;
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
        System.out.println(largestSubarray(nums, n, k));
    }
}