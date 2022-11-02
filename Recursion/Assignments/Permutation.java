import java.util.*;
public class Permutation{
    static List<String> result = new ArrayList<>();
    public static String swap(String str,int index1,int index2){
        char[] arr = str.toCharArray();
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return String.valueOf(arr);
    }
    public static void permutation(String str,int left,int right){
        if(left == right){
            result.add(str);
            return;
        }
        for(int i=left;i<=right;i++){
            str = swap(str,left,i);
            permutation(str, left+1, right);
            str = swap(str,left,i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        permutation(s, 0, s.length()-1);
        System.out.println(result);
        sc.close();
    }
}