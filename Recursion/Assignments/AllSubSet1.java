import java.util.*;
public class AllSubSet1 {
    static List<String> res = new ArrayList<>();
    public static void allSub(String str,int index,String temp){
        if(index == str.length()){
            res.add(temp);
            return;
        }
        allSub(str, index+1,temp);
        allSub(str, index+1,temp+""+str.charAt(index)+"");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        allSub(s, 0, "");
        System.out.println(res);
    }
}
