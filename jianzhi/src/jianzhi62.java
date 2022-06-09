import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
* 208. 实现 Trie (前缀树)
* */
public class jianzhi62 {

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

        public boolean search(String word) {
            Trie node = searchStart(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchStart(prefix) != null;
        }

        public Trie searchStart(String word){
            Trie node = this;
            for(int i = 0; i < word.length(); i++){
                char a = word.charAt(i);
                int index = a - 'a';
                if(node.children[index] == null){
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }

    }


}
