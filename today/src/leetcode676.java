import java.util.ArrayList;
import java.util.List;

/*
* 676. 实现一个魔法字典
* */
public class leetcode676 {

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


}
