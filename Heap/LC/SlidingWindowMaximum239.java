import java.util.*;
public class SlidingWindowMaximum239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len-k+1];
        for(int i=0;i<len;i++){
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(dq.peek() == i-k){
                dq.removeFirst();
            }
            if(i>=k-1){
                res[i-k+1] = nums[dq.peek()];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(maxSlidingWindow(nums, k));
    }
}
