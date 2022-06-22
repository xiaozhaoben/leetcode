import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;

/*
* 剑指 Offer II 107. 矩阵中的距离
* */
public class jianzhi107 {

    public static int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        boolean[][] flag = new boolean[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++){
            Arrays.fill(res[i], mat.length * 2 + 1);
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    res[i][j] = 0;
                }
            }
        }
        //递归
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                dfs1(mat, res, i, j);
            }
        }
        for(int i = mat.length - 1; i >= 0; i--){
            for(int j = mat[0].length - 1; j >= 0; j--){
                dfs2(mat, res, i, j);
            }
        }
        //动态规划
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(i > 0){
                    res[i][j] = Math.min(res[i - 1][j] + 1, res[i][j]);
                }
                if(j > 0){
                    res[i][j] = Math.min(res[i][j - 1] + 1, res[i][j]);
                }
            }
        }
        for(int i = mat.length - 1; i >= 0; i--){
            for(int j = mat[0].length - 1; j >= 0; j--){
                if(i < mat.length - 1){
                    res[i][j] = Math.min(res[i + 1][j] + 1, res[i][j]);
                }
                if(j < mat[0].length - 1){
                    res[i][j] = Math.min(res[i][j + 1] + 1, res[i][j]);
                }
            }
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        return res;
    }

    public static int dfs1(int[][] mat, int[][] res, int i, int j){
        if(i > 0){
            res[i][j] = Math.min(dfs1(mat, res, i - 1, j) + 1, res[i][j]);
        }
        if(j > 0){
            res[i][j] = Math.min(dfs1(mat, res, i, j - 1) + 1, res[i][j]);
        }
        return res[i][j];
    }

    public static int dfs2(int[][] mat, int[][] res, int i, int j){
        if(i < mat.length - 1){
            res[i][j] = Math.min(dfs2(mat, res, i + 1, j) + 1, res[i][j]);
        }
        if(j < mat[0].length - 1){
            res[i][j] = Math.min(dfs2(mat, res, i, j + 1) + 1, res[i][j]);
        }
        return res[i][j];
    }




    public static void main(String[] args) {
        updateMatrix(new int[][]{{0,0,0,0},{0,0,0,1},{0,1,1,1},{0,1,1,1}});
    }

}
