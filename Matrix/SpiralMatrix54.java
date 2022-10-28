package Matrix;
import java.util.*;
public class SpiralMatrix54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length,col = matrix[0].length;
        int top=0,down=row-1,left=0,right=col-1,direction=0;
        while(left<=right && top<=down){
            if(direction == 0){
                for(int i=left;i<=right;i++){
                    res.add(matrix[top][i]);
                }
                top++;
            }else if(direction == 1){
                for(int i=top;i<=down;i++){
                    res.add(matrix[i][right]);
                }
                right--;
            }else if(direction == 2){
                for(int i=right;i>=left;i--){
                    res.add(matrix[down][i]);
                }
                down--;
            }else{
                for(int i=down;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
            direction = (direction+1)%4;
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.println(spiralOrder(matrix));
    }
}
