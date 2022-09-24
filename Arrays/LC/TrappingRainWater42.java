import java.util.Scanner;

public class TrappingRainWater42 {
    public static int trap(int[] height) {
        int totTrappedWater = 0, len = height.length;
        int left = 1, right = len - 2;
        int leftMax = height[0], rightMax = height[len - 1];
        while (left <= right) {
            if (leftMax < rightMax) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totTrappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totTrappedWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totTrappedWater;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(trap(height));
    }
}
