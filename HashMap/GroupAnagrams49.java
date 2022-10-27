import java.util.*;

public class GroupAnagrams49 {
    public static List<List<String>> groupAnagrams(String[] str) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<str.length;i++){
            String original = str[i];
            char[] sorted = original.toCharArray();
            Arrays.sort(sorted);
            String sort = new String(sorted);
            List<String> list = map.getOrDefault(sort,new ArrayList<>());
            list.add(original);
            map.put(sort,list);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        sc.close();
        System.out.println(groupAnagrams(str));
    }
}
