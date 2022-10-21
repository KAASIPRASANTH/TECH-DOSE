import java.util.*;
public class NumberOfSubmatricesThatSumToTarget1074 {
    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int count = 0;
        for(int col=1;col<c;col++){
            for(int row=0;row<r;row++){
                matrix[row][col]+=matrix[row][col-1];
            }
        }
        for(int c1=0;c1<c;c1++){
            for(int c2=c1;c2<c;c2++){
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int sum = 0;
                for(int row=0;row<r;row++){
                    sum+=matrix[row][c2]-(c1>0?matrix[row][c1-1]:0);
                    count += map.getOrDefault(sum-target,0);
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,0},
                {1,1,1},
                {0,1,0}
        };
        int target = 0;
        System.out.println(numSubmatrixSumTarget(matrix,target));
    }
}
