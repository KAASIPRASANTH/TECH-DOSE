import java.util.*;
public class VerticalOrderTraversal987 {
    static TreeNode root;
    static Map<Integer,PriorityQueue<int[]>> map;

    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void preorder(TreeNode root, int x,int y) {
        if (root != null) {
            PriorityQueue<int[]> pq = map.getOrDefault(y,new PriorityQueue<>((a,b)->{
                if(a[0] == b[0]){
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }));
            pq.add(new int[]{x,root.data});
            map.put(y,pq);
            preorder(root.left, x+1,y-1);
            preorder(root.right, x+1,y+1);
        }
    }

    public static void main(String[] args) {

        //TC 1
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        //TC 2
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.left = new TreeNode(8);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);


        map = new TreeMap<>();
        preorder(root, 0,0);
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, PriorityQueue<int[]>> o:map.entrySet()){
            PriorityQueue<int[]> pq = o.getValue();
            while(!pq.isEmpty()){
                int[] arr = pq.poll();
                res.add(arr[1]);
            }
        }
        System.out.println(res);
    }
}

/*
 TC1

X
     |       |           |            |
0    |       |          (1)           |
     |       |           |            |
1    |      (2)          |           (3)
     |       |           |            | 
     |       |           |            | 
2   (4)      |        (5) (6)         |
     |       |           |            | 
    
   -2      -1           0            1 -----> Y


 */