public class SearchA2DMatrix74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int c = matrix[0].length;
        for(int[] arr : matrix){
            if(arr[0]>target && target>arr[c-1]){
                continue;
            }
            int left = 0,right = c-1;
            while(left<=right){
                int mid = left+(right-left)/2;
                if(arr[mid] == target){
                    return true;
                }
                if(arr[mid]<target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        System.out.println(searchMatrix(matrix,3));
    }
}
