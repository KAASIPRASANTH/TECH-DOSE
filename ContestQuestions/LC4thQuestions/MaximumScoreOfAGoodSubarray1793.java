import  java.util.*;
public class MaximumScoreOfAGoodSubarray1793 {
    public static int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && nums[stk.peek()]>=nums[i]){
                stk.pop();
            }
            left[i] = stk.isEmpty()?-1:stk.peek();
            stk.push(i);
        }
        stk.clear();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && nums[stk.peek()] >= nums[i]){
                stk.pop();
            }
            right[i] = stk.isEmpty()?n:stk.peek();
            stk.push(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(left[i] < k && k<right[i]){
                max = Math.max(max,(right[i]-left[i]-1)*nums[i]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        System.out.println(maximumScore(nums,k));
    }
}
