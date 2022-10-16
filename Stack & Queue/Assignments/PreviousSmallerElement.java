import java.util.*;

public class PreviousSmallerElement {
    public static int[] previousSmaller(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            left[i] = stk.isEmpty() ? -1 : nums[stk.peek()];
            stk.push(i);
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        int[] res = previousSmaller(nums);
        for (Integer val : res) {
            System.out.print(val + " ");
        }
    }
}
