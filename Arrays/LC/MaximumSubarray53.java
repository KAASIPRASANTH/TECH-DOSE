import java.util.Scanner;

public class MaximumSubarray53 {
    public static int maxSubArray(int[] nums) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (currSum < nums[i]) {
                currSum = nums[i];
            }
            if (maxSum < currSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(maxSubArray(nums));
    }
}
