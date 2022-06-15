import java.util.*;

/*
* 剑指 Offer II 086. 分割回文子字符串
* */
public class jianzhi86 {

    static List<List<String>> ans = new ArrayList<>();

    public static String[][] partition(String s) {
        backtrack(0, s, new StringBuilder(), new LinkedList<String>());
        String[][] res = new String[ans.size()][];
        for(int i = 0; i < res.length; i++){
            List<String> strings = ans.get(i);
            res[i] = new String[strings.size()];
            for(int j = 0; j < strings.size(); j++){
                res[i][j] = strings.get(j);
            }
        }
        return res;
    }

    public static void backtrack(int index, String s, StringBuilder word, List<String> path){
        if(index == s.length()){
            if (word.toString().equals("")){
                ans.add(new LinkedList(path));
            }
            return;
        }
        word.append(s.charAt(index));
        backtrack(index + 1, s, word, path);
        if(isPalindrome(word.toString())){
            path.add(word.toString());
            backtrack(index + 1, s, new StringBuilder(), path);
            path.remove(path.size() - 1);
        }
        word.deleteCharAt(word.length() - 1);
    }

    public static boolean isPalindrome(String word){
        int left = 0, right = word.length() - 1;
        while (left <= right){
            if (word.charAt(left) == word.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(partition("google")));
    }

}
