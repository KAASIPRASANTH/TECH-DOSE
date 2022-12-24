import java.util.*;

public class CourseSchedule207 {
    public static boolean topo(List<List<Integer>> al, int[] inDeg, int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + inDeg[i]);
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
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
        return res.size() == n;
    }

    public boolean canFinish(int n, int[][] prereq) {
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        int[] inDeg = new int[n];
        for (int[] con : prereq) {
            al.get(con[1]).add(con[0]);
            inDeg[con[0]]++;
        }
        return topo(al, inDeg, n);
    }
}