import java.util.*;

public class OneThreeTwoPattern456 {
    public static boolean find132pattern(int[] nums) {
        int n = nums.length,mid = Integer.MIN_VALUE;
        Stack<Integer> stk = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(mid > nums[i]){
                return  true;
            }
            while(!stk.isEmpty() && nums[i]>nums[stk.peek()]){
                mid = stk.pop();
            }
            stk.push(i);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(find132pattern(nums));
    }
}
