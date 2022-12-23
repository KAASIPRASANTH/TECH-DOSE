import java.util.*;

public class CycleDetection1 {
    public static boolean DFS(List<List<Integer>> al, boolean[] visited, int curr, int parent) {
        visited[curr] = true;
        for (int i = 0; i < al.get(curr).size(); i++) {
            int adj = al.get(curr).get(i);
            if (visited[adj] == false) {
                if (DFS(al, visited, adj, curr)) {
                    return true;
                }
            } else if (adj != parent) {
                return true;
            }
        }
        return false;
    }

    public static void isCycle(List<List<Integer>> al, int n) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == false && DFS(al, visited, i, -1)) {
                System.out.println("Cycle");
                break;
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        al.get(0).add(1);
        al.get(0).add(3);// ----------> Add an edge for not cycle

        al.get(1).add(0);
        al.get(1).add(2);

        al.get(2).add(1);
        al.get(2).add(3);

        al.get(3).add(0);// ---------> Add an edge for not cycle
        al.get(3).add(2);
        isCycle(al, n);
    }
}
