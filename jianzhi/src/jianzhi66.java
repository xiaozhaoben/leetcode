import java.util.HashMap;
import java.util.Map;

/*
* 剑指 Offer II 063. 替换单词
* */
public class jianzhi66 {

    class MapSum {

        /** Initialize your data structure here. */
        public MapSum() {
            map = new HashMap<>();
            trie = new Trie();
        }

        public void insert(String key, int val) {
            if(!map.containsKey(key)){
                trie.insert(key, val);
            }else {
                trie.insert(key, val - map.get(key));
            }
            map.put(key, val);
        }

        public int sum(String prefix) {
            return trie.sum(prefix);
        }

        Map<String, Integer> map;
        Trie trie;

        class Trie{

            private Trie[] children;
            private Integer value;

            public Trie() {
                children = new Trie[26];
                value = 0;
            }

            public void insert(String word, int value){
                Trie node = this;
                for(int i = 0; i < word.length(); i++){
                    char a = word.charAt(i);
                    int index = a - 'a';
                    if(node.children[index] == null){
                        node.children[index] = new Trie();
                    }
                    node.value = node.value + value;
                    node = node.children[index];
                }
                node.value = node.value + value;
            }

            public int sum(String word){
                Trie node = this;
                for(int i = 0; i < word.length(); i++){
                    char a = word.charAt(i);
                    int index = a - 'a';
                    if(node.children[index] == null){
                        return 0;
                    }
                    node = node.children[index];
                }
                return node.value;
            }

        }

    }


}
