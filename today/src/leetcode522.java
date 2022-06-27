
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
* 522. 最长特殊序列 II
* */
public class leetcode522 {

    static Map<String, Integer> map = new HashMap<>();

    public static int findLUSlength(String[] strs) {
        for(int i = 0; i < strs.length; i++){
            dfs(strs[i], 0, new StringBuilder());
        }
        int max = -1;
        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string + " " + map.get(string));
            if(map.get(string) == 1){
                max = Math.max(max, string.length());
            }
        }
        return max;
    }

    public static void dfs(String word, int index, StringBuilder res){
        map.put(res.toString(), map.getOrDefault(res.toString(), 0) + 1);
        if(index == word.length()){
            return;
        }
        for(int i = index; i < word.length(); i++){
            res.append(word.charAt(i));
            dfs(word, i + 1, res);
            res.delete(res.length() - 1, res.length());
        }
    }

    public static void main(String[] args) {
        System.out.println(findLUSlength(new String[]{"aba", "cdc", "eae"}));
    }

    //枚举
    class Solution {
        public int findLUSlength(String[] strs) {
            int n = strs.length;
            int ans = -1;
            for (int i = 0; i < n; ++i) {
                boolean check = true;
                for (int j = 0; j < n; ++j) {
                    if (i != j && isSubseq(strs[i], strs[j])) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    ans = Math.max(ans, strs[i].length());
                }
            }
            return ans;
        }

        public boolean isSubseq(String s, String t) {
            int ptS = 0, ptT = 0;
            while (ptS < s.length() && ptT < t.length()) {
                if (s.charAt(ptS) == t.charAt(ptT)) {
                    ++ptS;
                }
                ++ptT;
            }
            return ptS == s.length();
        }
    }

}
