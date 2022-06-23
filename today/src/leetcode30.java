import java.util.*;

/*
* 30. 串联所有单词的子串
* */
public class leetcode30 {

    //错误解答
    public List<Integer> findSubstring(String s, String[] words) {
        int[] a = new int[s.length() + 1];
        int length = words[0].length();
        Arrays.fill(a, -1);
        Arrays.sort(words);
        for(int i = 0; i < words.length; i++){
            int j = 0;
            while (s.indexOf(words[i], j) != -1){
                a[s.indexOf(words[i], j++)] = i;
            }
        }
        for(int i = 0; i < a.length - length; i++){
            if(a[i] != -1 && a[i] == a[i + length]){
                if(a[i] - 1 >= 0 && words[a[i]].equals(words[a[i] - 1])){
                    int sum = 0;
                    while (i + length * sum < a.length && a[i] == a[i + length * sum]){
                        sum++;
                    }
                    int j = 1;
                    while (a[i] - j >= 0 && words[a[i]].equals(words[a[i] - j])){
                        j++;
                    }
                    int index = 0;
                    for(int k = 0; k < sum; k++){
                        if(index == j){
                            index = 0;
                        }
                        a[i + k * length] = a[i] - index++;
                    }
                }
            }
        }
        // for(int i = 0; i < a.length; i++)
        //     System.out.print(a[i] + " ");
        List<Integer> ans = new ArrayList<>();
        boolean[] b = new boolean[words.length];
        for(int i = 0; i < s.length(); i++){
            if (a[i] == -1){
                continue;
            }
            boolean flag = true;
            for(int j = 0; j < words.length; j++){
                if (i + j * length >= a.length || a[i + j * length] == -1){
                    flag = false;
                    break;
                }
                if(b[a[i + j * length]]){
                    flag = false;
                    break;
                }else{
                    b[a[i + j * length]] = true;
                }
            }
            if(flag){
                ans.add(i);
            }
            Arrays.fill(b, false);
        }
        return ans;
    }

    //官方解答
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<Integer>();
            int m = words.length, n = words[0].length(), ls = s.length();
            for (int i = 0; i < n; i++) {
                if (i + m * n > ls) {
                    break;
                }
                Map<String, Integer> differ = new HashMap<String, Integer>();
                for (int j = 0; j < m; j++) {
                    String word = s.substring(i + j * n, i + (j + 1) * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                }
                for (String word : words) {
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                for (int start = i; start < ls - m * n + 1; start += n) {
                    if (start != i) {
                        String word = s.substring(start + (m - 1) * n, start + m * n);
                        differ.put(word, differ.getOrDefault(word, 0) + 1);
                        if (differ.get(word) == 0) {
                            differ.remove(word);
                        }
                        word = s.substring(start - n, start);
                        differ.put(word, differ.getOrDefault(word, 0) - 1);
                        if (differ.get(word) == 0) {
                            differ.remove(word);
                        }
                    }
                    if (differ.isEmpty()) {
                        res.add(start);
                    }
                }
            }
            return res;
        }
    }

}
