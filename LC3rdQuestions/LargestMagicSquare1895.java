public class LargestMagicSquare1895 {
    public static boolean isMagicalSquare(int[][] rowSum, int[][] colSum, int[][] grid, int x, int y, int k) {
        int sum = rowSum[x][y + k - 1] - rowSum[x][y] + grid[x][y];

        // checking all the row size = k
        for (int i = x; i < x + k; i++) {
            if ((rowSum[i][y + k - 1] - rowSum[i][y] + grid[i][y]) != sum) {
                return false;
            }
        }

        // checking all the col's
        for (int i = y; i < y + k; i++) {
            if ((colSum[x + k - 1][i] - colSum[x][i] + grid[x][i]) != sum) {
                return false;
            }
        }

        int diagSum1 = 0, diagSum2 = 0;
        int[][] subArray = new int[k][k];
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                subArray[i - x][j - y] = grid[i][j];
            }
        }
        for (int i = 0; i < k; i++) {
            diagSum1 += subArray[i][i];
            diagSum2 += subArray[i][k - i - 1];
        }
        if (diagSum1 != sum || diagSum2 != sum) {
            return false;
        }
        return true;
    }

    public static int largestMagicSquare(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] rowSum = new int[row][col];
        int[][] colSum = new int[row][col];

        // Row Sum
        for (int i = 0; i < row; i++) {
            rowSum[i][0] = grid[i][0];
        }
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                rowSum[i][j] = rowSum[i][j - 1] + grid[i][j];
            }
        }

        // Column Sum
        for (int i = 0; i < col; i++) {
            colSum[0][i] = grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                colSum[i][j] = colSum[i - 1][j] + grid[i][j];
            }
        }
        int size = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int MaxPossible = Math.min(row - i, col - j);
                for (int k = MaxPossible; k > 1; k--) {
                    if (isMagicalSquare(rowSum, colSum, grid, i, j, k)) {
                        size = Math.max(size, k);
                        break;
                    }
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 7, 1, 4, 5, 6 },
                { 2, 5, 1, 6, 4 },
                { 1, 5, 4, 3, 2 },
                { 1, 2, 7, 3, 4 }
        };
        System.out.println(largestMagicSquare(grid));
    }
}
