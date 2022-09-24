import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] arr,int n,int ele){
        int low=0,high=n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == ele){
                return arr[mid];
            }else if(ele<arr[mid]){
                high--;
            }else{
                low++;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int ele = sc.nextInt();
        sc.close();
        System.out.println(binarySearch(arr,n,ele));
    }
}
