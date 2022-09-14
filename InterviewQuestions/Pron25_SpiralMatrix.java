import java.util.*;

public class Pron25_SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = col - 1, top = 0, down = row - 1, direction = 0;
        while (top <= down && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
                down--;
            } else if (direction == 3) {
                for (int i = down; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(spiralOrder(matrix));
    }
}
