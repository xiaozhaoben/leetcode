import java.util.ArrayList;
import java.util.List;

/*
 * 1260. 二维网格迁移
 * */
public class leetcode1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int length = grid.length * grid[0].length;
        int[] target = new int[length];
        k = k % length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int index = (i * grid[0].length + j + k) % length;
                target[index] = grid[i][j];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < length; ) {
            for (int j = 0; j < grid[0].length; j++) {
                path.add(target[i++]);
            }
            ans.add(new ArrayList<>(path));
            path.clear();
        }
        return ans;
    }


}
