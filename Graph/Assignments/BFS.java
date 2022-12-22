import java.util.*;

public class BFS {
    static List<Integer> res;

    public static void bfs(List<List<Integer>> al, boolean[] visited, int curr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        visited[curr] = true;
        while (!q.isEmpty()) {
            int parent = q.poll();
            for (int i = 0; i < al.get(parent).size(); i++) {
                int adj = al.get(parent).get(i);
                if (visited[adj] == false) {
                    visited[adj] = true;
                    q.add(adj);
                }
            }
            res.add(parent);
        }
    }

    public static void main(String[] args) {
        int n = 8;
        res = new ArrayList<>();
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        // vertex 1
        al.get(1).add(2);
        al.get(1).add(3);
        al.get(1).add(4);

        // vertex 2
        al.get(2).add(1);
        al.get(2).add(5);

        // vertex 3
        al.get(3).add(1);
        al.get(3).add(5);
        al.get(3).add(6);

        // vertex 4
        al.get(4).add(1);
        al.get(4).add(6);
        al.get(4).add(7);

        // vertex 5
        al.get(5).add(2);
        al.get(5).add(3);
        al.get(5).add(8);

        // vertex 6
        al.get(6).add(3);
        al.get(6).add(8);

        // vertex 7
        al.get(7).add(4);
        al.get(7).add(8);

        // vertex 8
        al.get(8).add(5);
        al.get(8).add(6);
        al.get(8).add(7);

        bfs(al,new boolean[n+1],1);
        System.out.println("BFS " + res);
    }
}
