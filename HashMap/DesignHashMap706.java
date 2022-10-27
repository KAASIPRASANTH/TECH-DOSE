public class DesignHashMap706{
    static int[] hash = new int[1000001];
    public DesignHashMap706() {
        for(int i=0;i<1000001;i++){
            hash[i] = -1;
        }
    }
    
    public static void put(int key, int value) {
        hash[key] = value;
    }
    
    public static int get(int key) {
        return hash[key];
    }
    
    public static void remove(int key) {
        hash[key] = -1;
    }
    public static void main(String[] args) {
        /*
         Input:
         ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
         [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
        
         Output:
         [null, null, null, 1, -1, null, 1, null, -1]

         */
    }
}