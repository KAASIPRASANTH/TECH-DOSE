import java.util.*;
public class FindAllAnagramsInAString438 {
    public static List<Integer> findAnagrams(String s, String p) {
        if(s.length()==0||p.length()==0||s.length()<p.length()){
            return new ArrayList<>();
        }
        int[] hash = new int[26];
        for(int i=0;i<p.length();i++){
            hash[p.charAt(i)-'a']++;
        }
        int start = 0,end = 0,len = p.length(),diff=len;
        List<Integer> res = new ArrayList<>();
        for(;end<p.length();end++){
            char ch = s.charAt(end);
            hash[ch-'a']--;
            if(hash[ch-'a']>=0){
                diff--;
            }
        }
        if(diff == 0){
            res.add(0);
        }
        while(end<s.length()){
            char ch = s.charAt(start++);
            if(hash[ch-'a']>=0){
                diff++;
            }
            hash[ch-'a']++;
            ch = s.charAt(end++);
            hash[ch-'a']--;
            if(hash[ch-'a']>=0){
                diff--;
            }
            if(diff == 0){
                res.add(start);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        System.out.println(findAnagrams(s, p));
        sc.close();
    }
}
