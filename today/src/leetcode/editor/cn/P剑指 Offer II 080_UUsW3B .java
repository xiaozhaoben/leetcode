//////给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//////
////// 
//////
////// 示例 1: 
//////
////// 
//////输入: n = 4, k = 2
//////输出:
//////[
////// [2,4],
////// [3,4],
////// [2,3],
////// [1,2],
////// [1,3],
////// [1,4],
//////] 
//////
////// 示例 2: 
//////
////// 
//////输入: n = 1, k = 1
//////输出: [[1]] 
//////
////// 
//////
////// 提示: 
//////
////// 
////// 1 <= n <= 20 
////// 1 <= k <= n 
////// 
//////
////// 
//////
////// 注意：本题与主站 77 题相同： https://leetcode-cn.com/problems/combinations/ 
////// Related Topics 数组 回溯 👍 22 👎 0
////
//


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 含有 k 个元素的组合
 * @author xiao__zhao
 * @date 2022-06-16 03:17:36
 */
class PuUsW3B{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new PuUsW3B().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		dfs(n, k, new ArrayList<>(), 1);
		return ans;
	}

	public void dfs(int n, int k, List<Integer> path, int index){
		if(path.size() == k){
			ans.add(new ArrayList<>(path));
			return;
		}
		if (index == n + 1){
			return;
		}
		path.add(index);
		dfs(n, k, path, index + 1);
		path.remove(path.size() - 1);
		dfs(n, k, path, index + 1);
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}