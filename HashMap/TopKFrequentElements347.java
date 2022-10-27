import java.util.*;

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        });
        for (Map.Entry<Integer, Integer> o : map.entrySet()) {
            int key = o.getKey();
            int val = o.getValue();
            pq.add(new int[] { key, val });
        }
        while (k-- > 0) {
            res.add(pq.poll()[0]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
      /*Example 1:
      Input: nums = [1,1,1,2,2,3], k = 2
      Output: [1,2] 
      Example 2:
      Input: nums = [1], k = 1
      Output: [1]
      */
    }
}
