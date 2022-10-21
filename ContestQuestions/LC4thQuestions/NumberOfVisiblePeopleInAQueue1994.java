import java.util.*;
public class NumberOfVisiblePeopleInAQueue1994 {
    public static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=n-1;i>=0;i--){
            int count = 0;
            while(!stk.isEmpty() && heights[i] > heights[stk.peek()]){
                stk.pop();
                count++;
            }
            res[i] = stk.isEmpty()? count : count+1;
            stk.push(i);
        }
        return  res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for(int i=0;i<n;i++){
            heights[i] = sc.nextInt();
        }
        sc.close();
        int[] res = canSeePersonsCount(heights);
        for(int val:res){
            System.out.print(val+" ");
        }
    }
}
