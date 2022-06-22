/*
* 剑指 Offer II 105. 岛屿的最大面积
* */
public class jianzhi105 {

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                ans = Math.max(ans, dyeing(grid, i, j));
            }
        }
        return ans;
    }

    public int dyeing(int[][] grid, int i, int j){
        if(grid[i][j] == 0){
            return 0;
        }
        int sum = 0;
        if(grid[i][j] == 1){
            grid[i][j] = 0;
            sum++;
        }
        if(i < grid.length - 1){
            sum += dyeing(grid, i + 1, j);
        }
        if(j < grid[0].length - 1){
            sum += dyeing(grid, i, j + 1);
        }
        if(i > 0){
            sum += dyeing(grid, i - 1, j);
        }
        if(j > 0){
            sum += dyeing(grid, i, j - 1);
        }
        return sum;
    }

}
