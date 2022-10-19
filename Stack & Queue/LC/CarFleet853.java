import java.util.*;
public class CarFleet853 {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        Map<Integer,Double> map = new TreeMap<>();
        for(int i=0;i<n;i++){
            map.put(position[i],((double)(target - position[i])/speed[i]));
        }
        Arrays.sort(position);
        Stack<Double> stk = new Stack<>();
        stk.push(map.get(position[n-1]));
        for(int i=n-2;i>=0;i--){
            if(map.get(position[i])>stk.peek()){
                stk.push(map.get(position[i]));
            }
        }
        return stk.size();
    }
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(carFleet(target,position,speed));
    }
}
