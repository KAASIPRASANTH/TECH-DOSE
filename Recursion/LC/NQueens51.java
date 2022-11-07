import java.util.*;

public class NQueens51 {
    static List<List<String>> res;

    public static boolean isValid(char[][] arr, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < arr.length; j++) {
                // for same column
                if (y == j && arr[i][j] == 'Q') {
                    return false;
                }
                // for left & right diagonal
                if (Math.abs(x - i) == Math.abs(y - j) && arr[i][j] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<String> toListOfString(char[][] arr) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            temp.add(new String(arr[i]));
        }
        return temp;
    }

    public static void solve(char[][] arr, int row) {
        if (row == arr.length) {
            List<String> temp = new ArrayList<>(toListOfString(arr));
            res.add(temp);
            return;
        }
        for (int col = 0; col < arr.length; col++) {
            arr[row][col] = 'Q';
            if (isValid(arr, row, col)) {
                solve(arr, row + 1);
            }
            arr[row][col] = '.';
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], '.');
        }
        solve(arr, 0);
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}