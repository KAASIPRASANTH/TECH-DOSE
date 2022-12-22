import java.util.*;

public class CycleDetectionUsingDisjointSet {
    static int[] disJionSet;

    public static int find(int vertex) {
        if (disJionSet[vertex] == -1) {
            return vertex;
        }
        return find(disJionSet[vertex]);
    }

    public static void union(int AbsParent1, int AbsParent2) {
        disJionSet[AbsParent1] = AbsParent2;
    }

    public static boolean isCyclic(int[][] Edges, int n) {
        for (int[] edge : Edges) {
            int AbsParent1 = find(edge[0]);
            int AbsParent2 = find(edge[1]);

            if (AbsParent1 == AbsParent2) {
                return true;
            }
            union(AbsParent1, AbsParent2);
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 3;
        disJionSet = new int[n + 1];
        Arrays.fill(disJionSet, -1);
        int[][] Edges = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 2, 3 } };
        if (isCyclic(Edges, n)) {
            System.out.println("Cyclic graph");
        } else {
            System.out.println("Not cyclic graph");
        }
    }
}
