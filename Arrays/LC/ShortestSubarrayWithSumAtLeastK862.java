import java.util.*;

public class ShortestSubarrayWithSumAtLeastK862 {
    public static int shortestSubarray(int[] nums, int k) {
        Deque<Pair<Long, Integer>> dq = new ArrayDeque<>();
        int size = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= k)
                size = Math.min(size, i + 1);
            Pair<Long, Integer> p = new Pair(sum, i);
            Pair curr = new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
            while (!dq.isEmpty() && (sum - dq.getFirst().getKey()) >= k) {
                curr = dq.getFirst();
                dq.removeFirst();
            }
            // if we removed any element from front just calculate new size
            if ((int) curr.getValue() != (int) Integer.MIN_VALUE) {
                size = Math.min(size, (i - (int) curr.getValue()));
            }
            while (!dq.isEmpty() && sum <= dq.getLast().getKey()) {
                dq.removeLast();
            }
            dq.addLast(p);
        }
        return size == Integer.MAX_VALUE ? -1 : size;
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
        System.out.println(shortestSubarray(nums, k));
    }
}
