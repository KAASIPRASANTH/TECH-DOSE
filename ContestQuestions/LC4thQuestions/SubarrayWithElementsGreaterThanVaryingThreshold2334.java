import java.util.*;
public class SubarrayWithElementsGreaterThanVaryingThreshold2334 {
    public static int validSubarraySize(int[] nums, int threshold) {
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
            while(!stk.isEmpty() && nums[stk.peek()]>=nums[i]){
                stk.pop();
            }
            right[i] = stk.isEmpty()?n:stk.peek();
            stk.push(i);
        }
        int maxSize = -1;
        for(int i=0;i<n;i++){
            int len = (right[i]-left[i]-1);
            if((threshold/(double)len) < nums[i]){
                maxSize = Math.max(maxSize,len);
                //return len;
            }
        }
        return maxSize;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int threshold = sc.nextInt();
        System.out.println(validSubarraySize(nums,threshold));
    }
}
