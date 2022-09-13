import java.util.*;
public class Prob11_verifyingAnAlienDictionary{
    public static boolean Compare(String s1,String s2,int[] hash){
        int len1 = s1.length(),len2 = s2.length();
        int i=0,j=0;
        for(;i<len1 && j<len2;i++,j++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(j);
            if(ch1 != ch2){
                return hash[ch1]>hash[ch2];
            }
        }
        return len1>len2;
    }
    public static boolean isAlienSorted(String[] words, String order) {
        int[] hash = new int[128];
        int n = words.length;
        for(int i=0;i<order.length();i++){
            hash[order.charAt(i)]=i;
        }
        for(int i=0;i<n-1;i++){
            if(Compare(words[i],words[i+1],hash)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = sc.next();
        }
        String order = sc.next();
        sc.close();
        System.out.println(isAlienSorted(words,order));
    }
}