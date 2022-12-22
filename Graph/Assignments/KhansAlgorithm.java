import java.util.*;

public class KhansAlgorithm {
    public static void topo(List<List<Integer>> al, int[] inDeg, int n) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int i = 0; i < al.get(poll).size(); i++) {
                int adj = al.get(poll).get(i);
                if (--inDeg[adj] == 0) {
                    q.add(adj);
                }
            }
            res.add(poll);
        }
        System.out.println(res);
        if (res.size() == n + 1) {
            System.out.print(res);
        } else {
            System.out.print("It's a cyclic graph");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }

        al.get(2).add(1);

        al.get(3).add(0);
        al.get(3).add(2);

        al.get(4).add(0);
        al.get(4).add(1);

        al.get(5).add(0);
        al.get(5).add(3);

        int[] inDeg = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < al.get(i).size(); j++) {
                inDeg[al.get(i).get(j)]++;
            }
        }
        topo(al, inDeg, n);
    }
}