import java.util.*;
public class DiagonalTraverseII1424 {
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size();
        Map<Integer,List<Integer>> map = new TreeMap<>();
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<nums.get(i).size();j++){
                List<Integer> list = map.getOrDefault(i+j,new ArrayList<>());
                list.add(nums.get(i).get(j));
                map.put(i+j,list);
            }

        }
        List<Integer> res = new ArrayList<>();
        for(List<Integer> list: map.values()){
            res.addAll(list);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,2,3));
        list.add(Arrays.asList(4,5,6));
        list.add(Arrays.asList(7,8,9));
        int[] res = findDiagonalOrder(list);
        for(int val:res){
            System.out.print(val+" ");
        }
    }
}
