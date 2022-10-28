package Matrix;

public class KthSmallestNumberInMultiplicationTable668 {
    public static int findKthNumber(int m, int n, int k) {
        int low = 1,high = m*n;
        while(low<=high){
            int mid = (low+high)/2;
            int count = 0;
            for(int i=1;i<=m;i++){
                count+=Math.min(mid/i,n);
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
        int m = 2,n = 3,k = 6;
        System.out.println(findKthNumber(m, n, k));
    }
}
