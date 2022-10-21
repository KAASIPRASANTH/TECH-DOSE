public class ContainerWithMostWater11 {
    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0,right = n-1,max = 0;
        while(left<right){
            if(height[left] < height[right]){
                max = Math.max(max,(right-left)*height[left++]);
            }else{
                max = Math.max(max,(right-left)*height[right--]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }
}
