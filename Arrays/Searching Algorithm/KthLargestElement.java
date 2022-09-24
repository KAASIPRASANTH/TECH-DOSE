import java.util.Scanner;

public class KthLargestElement {
    public static int partion(int[] arr, int low, int high) {
        int i = low - 1, j = low, pivot = arr[high], temp;
        for (; j < high; j++) {
            // finding if any value lesser than pivot
            if (arr[j] <= pivot) {
                i++;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        temp = arr[j];
        arr[j] = arr[i + 1];
        arr[i + 1] = temp;
        return i + 1;
    }

    public static int quickSort(int[] arr,int low,int high,int k){
        int partitionIndex = partion(arr,low,high);
        if(partitionIndex == k){
            return arr[partitionIndex];
        }else if(k<partitionIndex){
            return quickSort(arr, low, partitionIndex-1, k);
        }else{
            return quickSort(arr, partitionIndex+1, high, k);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        System.out.println(quickSort(arr, 0, n-1,n-k));
    }
}
