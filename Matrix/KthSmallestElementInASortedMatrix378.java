package Matrix;

public class KthSmallestElementInASortedMatrix378 {
    public static int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length , c = matrix[0].length;
        int low = matrix[0][0],high = matrix[r-1][c-1];
        while(low<=high){
            int mid = low+(high-low)/2,count=0,j=c-1;
            for(int i=0;i<r;i++){
                while(j>=0 && matrix[i][j]>mid){
                    j--;
                }
                if(j>=0) count+=(j+1);
            }
            if(count<k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,5,9},
            {10,11,13},
            {12,13,15}
        };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }
}
