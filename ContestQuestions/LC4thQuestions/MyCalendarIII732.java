import java.util.*;
public class MyCalendarIII732 {
    static Map<Integer,Integer> map;
    public static void MyCalendarThree() {
        map = new TreeMap<>();
    }

    public static int book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int max = 0,sum = 0;
        for(int val:map.values()){
            sum+=val;
            max = Math.max(max,sum);
        }
        return max;
    }
    public static void main(String[] args) {
        MyCalendarThree();
        System.out.println(book(10,20));
        System.out.println(book(50,60));
        System.out.println(book(10,40));
        System.out.println(book(5,15));
    }
}
