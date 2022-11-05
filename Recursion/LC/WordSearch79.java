package Recursion.LC;

public class WordSearch79 {
    static int row, col, len;
    static String s = "";

    public static boolean isPresent(char[][] arr, int x, int y, int index, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= row || y >= col || index >= len || visited[x][y] == true
                || arr[x][y] != s.charAt(index)) {
            return false;
        }
        if (index + 1 == len) {
            return true;
        }
        visited[x][y] = true;
        boolean left = isPresent(arr, x, y - 1, index + 1, visited);
        boolean right = isPresent(arr, x, y + 1, index + 1, visited);
        boolean top = isPresent(arr, x - 1, y, index + 1, visited);
        boolean down = isPresent(arr, x + 1, y, index + 1, visited);
        visited[x][y] = false;
        return (left || right || top || down);
    }

    public static boolean exist(char[][] board, String word) {
        s = word;
        len = s.length();
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (s.charAt(0) == board[i][j]) {
                    if (isPresent(board, i, j, 0, new boolean[row][col])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'D' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
