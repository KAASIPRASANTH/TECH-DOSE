import java.util.*;

public class prob68_SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return new int[0];
        }
        Deque<Integer> q = new LinkedList<>();
        int totWindows = n - k + 1, index = 0;
        int[] res = new int[totWindows];
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            // removing the first ele if it's not in give size of K
            if (q.peek() == i - k) {
                q.removeFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[q.peek()];
            }
        }
        return res;
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
        int[] res = maxSlidingWindow(nums, k);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}