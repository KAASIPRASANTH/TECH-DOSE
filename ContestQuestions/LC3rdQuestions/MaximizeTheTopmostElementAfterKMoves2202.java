import java.util.*;

public class MaximizeTheTopmostElementAfterKMoves2202 {
    public static int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 && k % 2 == 1)
            return -1;
        if (k == 0)
            return nums[0];
        if (k == 1)
            return nums[1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        if (n > k) {
            for (int i = 0; i <= k - 2; i++) {
                pq.add(nums[i]);
            }
            int poll = pq.poll();
            return Math.max(poll, nums[k]);
        } else {
            for (int i = 0; i < k - 1 && i < n; i++) {
                pq.add(nums[i]);
            }
            return pq.poll();
        }
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
        System.out.println(maximumTop(nums, k));
    }
}
