import java.util.*;

public class RottingOranges994 {
    static int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length, fresh = 0;
        Queue<int[]> rotten = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0)
            return 0;
        int minTime = 0;
        while (!rotten.isEmpty()) {
            int size = rotten.size();
            for (int i = 0; i < size; i++) {
                int[] pos = rotten.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        --fresh;
                        grid[x][y] = 2;
                        rotten.add(new int[] { x, y });
                    }
                }
            }
            minTime++;
        }
        return (fresh == 0) ? minTime - 1 : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        System.out.println(orangesRotting(grid));
    }
}
