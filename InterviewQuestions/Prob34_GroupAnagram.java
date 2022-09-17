import java.util.*;

public class Prob34_GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String original = strs[i];
            char[] arr = original.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            if (map.containsKey(sorted)) {
                map.get(sorted).add(original);
            } else {
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(original);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        sc.close();
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);
    }
}