public class leetcode498 {

    public int[] findDiagonalOrder(int[][] mat) {
        if(mat == null || mat.length == 0){
            return new int[]{};
        }
        int i = 0, j = 0;
        int row = mat.length, col = mat[0].length;
        int[] ans = new int[row * col];
        for(int x = 0; x < ans.length; x++){
            ans[x] = mat[i][j];
            if((i + j) % 2 == 0){
                if(j == col - 1){
                    i++;
                }else if(i == 0){
                    j++;
                }else{
                    i--;
                    j++;
                }
            }else{
                if(i == row - 1){
                    j++;
                }else if(j == 0){
                    i++;
                }else{
                    i++;
                    j--;
                }
            }
        }
        return ans;
    }

}
