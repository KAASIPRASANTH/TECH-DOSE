import java.util.Scanner;

public class MinimumSizeSubarraySum206 {
    public static int minSubArrayLen(int[] nums, int target) {
        int left = 0, right = 0, sum = 0, size = Integer.MAX_VALUE;
        for (; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                size = Math.min(size, right - left + 1);
                sum -= nums[left++];
            }
        }
        return size == Integer.MAX_VALUE ? 0 : size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        sc.close();
        System.out.println(minSubArrayLen(nums, target));
    }
}
