import java.util.*;

public class LargestRectangleInHistogram84 {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            left[i] = s.isEmpty() ? 0 : s.peek() + 1;
            s.push(i);
        }
        s.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            right[i] = s.isEmpty() ? n - 1 : s.peek() - 1;
            s.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = (right[i] - left[i] + 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
        System.out.println(largestRectangleArea(new int[] { 2, 4 }));
    }
}
