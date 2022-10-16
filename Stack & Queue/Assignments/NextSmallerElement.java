import java.util.*;

public class NextSmallerElement {
    public static int[] nextSmaller(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            right[i] = stk.isEmpty() ? -1 : nums[stk.peek()];
            stk.push(i);
        }
        return right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        int[] res = nextSmaller(nums);
        for (Integer val : res) {
            System.out.print(val + " ");
        }
    }

}
