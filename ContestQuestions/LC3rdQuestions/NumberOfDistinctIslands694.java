

import java.util.*;

public class NumberOfDistinctIslands694 {
    public static void dfs(int[][] grid, int i, int j, List<Integer> al, int row, int col) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;

        // to identify shape of the islands
        al.add(i - row);
        al.add(j - col);

        dfs(grid, i - 1, j, al, row, col);
        dfs(grid, i + 1, j, al, row, col);
        dfs(grid, i, j - 1, al, row, col);
        dfs(grid, i, j + 1, al, row, col);
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0 },
                { 1, 1, 0, 0 },
                { 0, 0, 1, 1 },
                { 0, 0, 1, 1 }
        };
        /*
         * int[][] grid = {
         * { 1, 1, 0, 0 },
         * { 1, 1, 0, 0 },
         * { 0, 0, 1, 0 },
         * { 0, 0, 1, 1 }
         * };
         */
        int row = 4, col = 4;
        Set<List<Integer>> s = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> al = new ArrayList<>();
                    dfs(grid, i, j, al, i, j);
                    s.add(al);
                }
            }
        }
        System.out.println(s.size());
    }
}
