

import java.util.*;

public class CustomSortString791 {
    public static String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        String res = "";
        for (int i = 0; i < order.length(); i++) {
            if (map.containsKey(order.charAt(i))) {
                int fre = map.get(order.charAt(i));
                res += ((order.charAt(i) + "").repeat(fre));
                map.remove(order.charAt(i));
            }
        }
        for (Map.Entry<Character, Integer> o : map.entrySet()) {
            int fre = o.getValue();
            char ch = o.getKey();
            res += ((ch + "").repeat(fre));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String order = sc.next();
        String s = sc.next();
        sc.close();
        System.out.println(customSortString(order, s));
    }
}
