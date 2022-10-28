package Matrix;

public class MedianInRowWiseSortedMatrix2387 {
    public static int findMedian(int[][] matrix) {
        int low = 0,high = Integer.MAX_VALUE,r=matrix.length,c=matrix[0].length;
        while(low<=high){
            int mid = (low+high)/2;
            int count = 0;
            for(int i=0;i<r;i++){
                int j = c-1;
                while(j>=0 && matrix[i][j]>mid){
                    j--;
                }
                if(j>=0) count+=(j+1);
            }
            if(count<=(r*c)/2){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,5,9,10},
            {56,78,90,100},
            {12,13,15,34}
        };
        System.out.println(findMedian(matrix));
    }
}
