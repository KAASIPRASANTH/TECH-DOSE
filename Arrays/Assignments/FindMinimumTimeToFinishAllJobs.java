import java.util.*;

public class FindMinimumTimeToFinishAllJobs {
    private static boolean isWorking(int[] nums, int n, int k, int mid) {
        int sum = 0, NumOfWorkers = k;
        for (int i = 0; i < n; i++) {
            if (nums[i] > mid) {
                return false;
            }
            if (sum + nums[i] >= mid) {
                sum = (sum + nums[i] <= mid) ? 0 : nums[i];
                if (NumOfWorkers > 0)
                    NumOfWorkers--;
                else
                    return false;
            } else {
                sum += nums[i];
            }
        }
        if (sum <= mid && NumOfWorkers > 0) {
            NumOfWorkers--;
            sum = 0;
        }
        return (sum == 0) ? true : false;
    }

    private static int minTime(int[] nums, int n, int k) {
        int minTime = Integer.MAX_VALUE;
        int low = nums[0], high = nums[0];
        for (int i = 1; i < n; i++) {
            low = Math.max(nums[i], low);
            high += nums[i];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean worked = isWorking(nums, n, k, mid);
            if (worked) {
                high = mid - 1;
                minTime = Math.min(minTime, mid);
            } else {
                low = mid + 1;
            }
        }
        return minTime;
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
        System.out.println(minTime(nums, n, k));
    }

}
