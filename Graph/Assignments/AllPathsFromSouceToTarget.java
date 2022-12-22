import java.util.*;

public class AllPathsFromSouceToTarget {
    static List<List<Integer>> res;
    static Stack<Integer> stk;

    public static void DFS(List<List<Integer>> al, boolean[] visited, int curr, int destination) {
        visited[curr] = true;
        stk.push(curr);
        if (curr == destination) {
            res.add(new ArrayList<>(stk));
            visited[curr] = false;
            stk.pop();
            return;
        }
        for (int i = 0; i < al.get(curr).size(); i++) {
            int adj = al.get(curr).get(i);
            if (visited[adj] == false) {
                DFS(al, visited, adj, destination);
            }
        }
        visited[curr] = false;
        stk.pop();
    }

    public static void main(String[] args) {
        int n = 5;
        res = new ArrayList<>();
        stk = new Stack<>();
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        int source = 1, destination = 5;
        // vertex 1
        al.get(1).add(2);
        al.get(1).add(3);

        // vertex 2
        al.get(2).add(1);
        al.get(2).add(4);
        al.get(2).add(5);

        // vertex 3
        al.get(3).add(1);
        al.get(3).add(5);

        // vertex 4
        al.get(4).add(2);
        al.get(4).add(5);

        // vertex 5
        al.get(5).add(2);
        al.get(5).add(3);
        al.get(5).add(4);
        DFS(al, new boolean[n + 1], source, destination);
        System.out.println("All Possible Paths : " + res);
    }
}
