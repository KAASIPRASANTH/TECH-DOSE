import java.util.*;

public class NQueensII52 {
    static List<List<String>> res;

    public static List<String> toListOfString(char[][] arr) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            temp.add(new String(arr[i]));
        }
        return temp;
    }

    public static boolean isValid(char[][] arr, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j == y && arr[i][j] == 'Q') {
                    return false;
                }
                if (Math.abs(x - i) == Math.abs(y - j) && arr[i][j] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void solveNQueens(char[][] arr, int row) {
        if (row == arr.length) {
            List<String> temp = toListOfString(arr);
            res.add(temp);
            return;
        }
        for (int col = 0; col < arr.length; col++) {
            arr[row][col] = 'Q';
            if (isValid(arr, row, col)) {
                solveNQueens(arr, row + 1);
            }
            arr[row][col] = '.';
        }
    }

    public static int totalNQueens(int n) {
        res = new ArrayList<>();
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], '.');
        }
        solveNQueens(arr, 0);
        return res.size();
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalNQueens(n));
    }
}
