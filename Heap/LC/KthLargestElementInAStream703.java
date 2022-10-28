import java.util.*;
public class KthLargestElementInAStream703 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int k;
    public KthLargestElementInAStream703(int k, int[] nums) {
       // this.k = k;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        while(pq.size()>k){
            pq.poll();
        }
    }
    
    public static int add(int val) {
        if(pq.size()<k){
            pq.add(val);
        }else if(pq.peek()<val){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        /*
          Input:
          ["KthLargest", "add", "add", "add", "add", "add"]
          [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
          Output:
          [null, 4, 5, 5, 8, 8]
         */
    }

}
