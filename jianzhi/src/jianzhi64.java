import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 剑指 Offer II 063. 替换单词
* */
public class jianzhi64 {

    //前缀树解法
    class MagicDictionary {

        private Trie trie;

        /** Initialize your data structure here. */
        public MagicDictionary() {
            trie = new Trie();
        }

        public void buildDict(String[] dictionary) {
            for(int i = 0; i < dictionary.length; i++){
                trie.insert(dictionary[i]);
            }
        }

        public boolean search(String searchWord) {
            return trie.check(searchWord);
        }

        class Trie {

            private Trie[] children;
            private boolean isEnd;

            public Trie() {
                children = new Trie[26];
                isEnd = false;
            }

            public void insert(String word) {
                Trie node = this;
                for(int i = 0; i < word.length(); i++){
                    char a = word.charAt(i);
                    int index = a - 'a';
                    if(node.children[index] == null){
                        node.children[index] = new Trie();
                    }
                    node = node.children[index];
                }
                node.isEnd = true;
            }

            public boolean check(String word){
                Trie node = this;
                for(int i = 0; i < word.length(); i++){
                    char a = word.charAt(i);
                    int index = a - 'a';
                    if(i < word.length()){
                        for(int j = 0; j < 26; j++){
                            if(node.children[j] != null && index != j){
                                Trie path = node.children[j];
                                boolean flag = true;
                                for(int z = i + 1; z < word.length(); z++){
                                    char b = word.charAt(z);
                                    int in = b - 'a';
                                    if(path.children[in] == null){
                                        flag = false;
                                        break;
                                    }
                                    path = path.children[in];
                                }
                                if(path.isEnd && flag){
                                    return true;
                                }
                            }
                        }
                    }
                    if(node.children[index] == null){
                        break;
                    }
                    node = node.children[index];
                }
                return false;
            }

        }

    }

//    class MagicDictionary {
//        Map<Integer, List<String>> map;
//
//        public MagicDictionary() {
//            map = new HashMap<>();
//        }
//
//        public void buildDict(String[] dictionary) {
//            for (String dic : dictionary) {
//                int len = dic.length();
//                if (!map.containsKey(len)) map.put(len, new ArrayList<>());
//                map.get(len).add(dic);
//            }
//        }
//
//        public boolean search(String searchWord) {
//            int len = searchWord.length();
//            if (!map.containsKey(len)) return false; //符合条件的必定是和要验证的字符串的长度相等的
//            for (String dic : map.get(len)) {
//                int cnt = 0; //修改次数
//                for (int i = 0; i < len; i++) {
//                    if (dic.charAt(i) != searchWord.charAt(i)) cnt++;
//                    if (cnt > 1) break;
//                }
//                if (cnt == 1) return true; //说明可以只修改一个字母,就使得所形成的新字符串能够与字典中的任一字符串匹配
//            }
//            return false;
//        }
//    }


}
