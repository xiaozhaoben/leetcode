/*
 * 面试题 01.07. 旋转矩阵
 * */
public class interview01_07 {

    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int temp;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
