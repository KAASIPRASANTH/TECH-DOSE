import java.util.*;
public class FirstUniqueCharacterInAString387 {
    public static int firstUniqChar(String s) {
        int[] hash = new int[26];
        for(int i=0;i<s.length();i++){
           hash[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(hash[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(firstUniqChar(sc.next()));
        sc.close();
    }
}
