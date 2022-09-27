import java.util.*;

public class CountUniqueCharactersOfAllSubstrings828 {
    public static int uniqueLetterString(String s) {
        int len = s.length(), res = 0;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            al.add(new ArrayList<>());
            al.get(i).add(0);
        }
        for (int i = 0; i < len; i++) {
            int pos = (int) (s.charAt(i) - 'A');
            al.get(pos).add(i);
        }
        for (int i = 0; i < 26; i++) {
            al.get(i).add(len);
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j < al.get(i).size() - 1; j++) {
                int left = (al.get(i).get(j) - al.get(i).get(j - 1));
                if (j == 1)
                    left += 1;
                int right = al.get(i).get(j + 1) - al.get(i).get(j);
                res += (left * right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        System.out.println(uniqueLetterString(s));
    }
}
