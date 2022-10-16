import java.util.*;

public class NextGreaterElementI496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int[] right = new int[l2];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int i = l2 - 1; i >= 0; i--) {
            map.put(nums2[i], i);
            while (!s.isEmpty() && nums2[s.peek()] <= nums2[i]) {
                s.pop();
            }
            right[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        int[] res = new int[l1];
        for (int i = 0; i < l1; i++) {
            int index = map.get(nums1[i]);
            res[i] = right[index] == -1 ? -1 : nums2[right[index]];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        System.out.println(nextGreaterElement(nums1, nums2));
    }
}
