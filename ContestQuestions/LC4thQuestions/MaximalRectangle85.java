import  java.util.*;
public class MaximalRectangle85 {
    public static int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int maxArea = -1;
        int[] heights = new int[c];
        for(int j=0;j<r;j++){
            Stack<Integer> stk = new Stack<>();
            int[] left = new int[c];
            int[] right = new int[c];
            for(int i=0;i<c;i++){
                heights[i] = matrix[j][i] == '1'?1+heights[i]:0;
            }
            for(int i=0;i<c;i++){
                while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]){
                    stk.pop();
                }
                left[i] = stk.isEmpty()?0:stk.peek()+1;
                stk.push(i);
            }
            stk.clear();
            for(int i=c-1;i>=0;i--){
                while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]){
                    stk.pop();
                }
                right[i] = stk.isEmpty()?c-1:stk.peek()-1;
                stk.push(i);

                maxArea = Math.max(maxArea,(right[i]-left[i]+1)*heights[i]);
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
}
