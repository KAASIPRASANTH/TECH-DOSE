import java.util.*;

public class KruskalAlgorithm {
    static int[] Parent;
    static int totWeight;

    public static int findAbsoluteParent(int vertex) {
        if (Parent[vertex] == -1) {
            return vertex;
        }
        return findAbsoluteParent(Parent[vertex]);
    }

    public static void kruskal(int[][] edges, int V, int E) {
        totWeight = 0;
        Parent = new int[V];
        Arrays.fill(Parent, -1);
        Arrays.sort(edges, (a, b) -> {
            if (a[0] == a[0]) {
                if (a[1] == a[1]) {
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int count = 0;
        for (int[] edge : edges) {
            int AP1 = findAbsoluteParent(edge[0]);
            int AP2 = findAbsoluteParent(edge[1]);
            if (AP1 != AP2) {
                Parent[AP1] = AP2;
                totWeight += edge[2];
                count++;
                if (count == V - 1) {
                    break;
                }
            }
        }
        System.out.println(totWeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] edges = new int[E][3];
        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        sc.close();
        kruskal(edges, V, E);
    }
}