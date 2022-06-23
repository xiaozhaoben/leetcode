import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 30. 串联所有单词的子串
* */
public class leetcode30 {

    public List<Integer> findSubstring(String s, String[] words) {
        int[] a = new int[s.length() + 1];
        int length = words[0].length();
        for(int i = 0; i < words.length; i++){
            int j = 0;
            while (s.indexOf(words[i], j) != -1){
                a[s.indexOf(words[i], j++)] = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int target = (words.length - 1) * words.length / 2;
        for(int i = 0; i < s.length(); i++){
            int sum = 0;
            for(int j = 0; j < words.length; j++){
                sum += a[i + j * length];
            }
            if (sum == target){
                ans.add(i);
            }
        }
        return ans;
    }

}
