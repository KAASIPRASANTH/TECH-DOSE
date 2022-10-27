import java.util.*;
public class InsertDeleteGetRandom380 {
    Set<Integer> set;
    List<Integer> al;
    
    public InsertDeleteGetRandom380() {
        set = new HashSet<>();
        al = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(set.add(val)){
            al.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            int index = al.indexOf(val);
            al.remove(index);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        double random = Math.random()*al.size();
        int pos = (int) random;
        return al.get(pos);
    }
    public static void main(String[] args) {
        /*
         Input
         ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
         [[], [1], [2], [2], [], [1], [2], []]
         Output
         [null, true, false, true, 2, true, false, 2]
         */
    }
}
