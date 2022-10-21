import  java.util.*;
public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray1526 {
    public static int minNumberOperations(int[] target) {
        Stack<Integer> stk = new Stack<>();
        int sum = target[0];
        stk.push(sum);
        for(int i=1;i<target.length;i++){
            if(stk.peek() < target[i]){
                sum += (target[i]-stk.peek());
            }
            stk.push(target[i]);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] target = new int[n];
        for(int i=0;i<n;i++) {
            target[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(minNumberOperations(target));
    }
}
