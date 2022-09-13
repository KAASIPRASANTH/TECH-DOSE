import java.util.*;
public class Prob14_ProductOfArraysExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        res[0] = 1;
        for(int i=1;i<size;i++){
            res[i] = nums[i-1]*res[i-1];
        }
        int right = 1;
        for(int i=size-1;i>=0;i--){
            res[i]*=right;
            right*=nums[i];
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
        nums = productExceptSelf(nums);
        for(int i=0;i<n;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
