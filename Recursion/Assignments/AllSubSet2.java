import java.util.*;

public class AllSubSet2 {
    static List<List<Integer>> res = new ArrayList<>();

    public static void allSub(int[] arr, int index, List<Integer> temp) {
        if (index == arr.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        allSub(arr, index + 1, temp);
        temp.add(arr[index]);
        allSub(arr, index + 1, temp);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 1, 2, 3 };
        allSub(arr, 0, new ArrayList<>());
        sc.close();
        System.out.println(res);
    }
}
