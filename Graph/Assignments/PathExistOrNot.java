import java.util.*;

public class PathExistOrNot {
    public static boolean DFS(List<List<Integer>> al, boolean[] visited, int curr, int destination) {
        visited[curr] = true;
        if (curr == destination) {
            return true;
        }
        for (int i = 0; i < al.get(curr).size(); i++) {
            int adj = al.get(curr).get(i);
            if (visited[adj] == false && DFS(al, visited, adj, destination)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }

        // vertex 1
        al.get(1).add(2);

        // vertex 2
        al.get(2).add(1);
        al.get(2).add(3);
        al.get(2).add(4);
        // al.get(2).add(5); -------> add this edge for path exist from 1 to 6

        // vertex 3
        al.get(3).add(2);
        al.get(3).add(4);

        // vertex 4
        al.get(4).add(2);
        al.get(4).add(3);

        // vertex 5
        al.get(5).add(6);
        // al.get(5).add(2); -------> add this edge for path exist from 1 to 6

        // vertex 6
        al.get(6).add(5);

        int source = 1, destination = 6;
        if (DFS(al, new boolean[n + 1], source, destination)) {
            System.out.println("Path Exist");
        } else {
            System.out.println("Path Not Exist");
        }
    }
}
