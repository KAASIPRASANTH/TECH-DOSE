class Solution {
    static Map<Integer,List<int[]>> map;
    public static void preorder(TreeNode root,int x,int y){
        if(root==null) return;
        List<int[]> temp = map.getOrDefault(y,new ArrayList<>());
        temp.add(new int[]{x,root.val});
        map.put(y,temp);
        preorder(root.left,x+1,y-1);
        preorder(root.right,x+1,y+1);
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new TreeMap<>();
        preorder(root,0,0);
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer,List<int[]>> obj:map.entrySet()){
            List<int[]> list = obj.getValue();
            Collections.sort(list,(a,b)->{
                return a[0] - b[0];
            });
            List<Integer> temp = new ArrayList<>();
            for(int[] a:list){
                temp.add(a[1]);
            }
            res.add(temp);
        }
        return res;
    }
}
