import java.util.*;

public class ValidSudoku36 {
    public static boolean isValidSudoku(String[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!board[i][j].equals(".")) {
                    String row = board[i][j] + " row " + i + "";
                    String col = board[i][j] + " col " + j + " ";
                    String box = board[i][j] + " box " + (i / 3) + " " + (j / 3);
                    if (!set.add(row) || !set.add(col) || !set.add(box)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] board = {
            { "5", "3", ".", ".", "7", ".", ".", ".", "." },
            { "6", ".", ".", "1", "9", "5", ".", ".", "." },
            { ".", "9", "8", ".", ".", ".", ".", "6", "." },
            { "8", ".", ".", ".", "6", ".", ".", ".", "3" },
            { "4", ".", ".", "8", ".", "3", ".", ".", "1" },
            { "7", ".", ".", ".", "2", ".", ".", ".", "6" },
            { ".", "6", ".", ".", ".", ".", "2", "8", "." },
            { ".", ".", ".", "4", "1", "9", ".", ".", "5" },
            { ".", ".", ".", ".", "8", ".", ".", "7", "9" }
        };
        System.out.println(isValidSudoku(board));
    }
}
