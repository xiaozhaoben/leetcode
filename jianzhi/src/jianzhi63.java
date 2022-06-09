import java.util.List;

/*
* 剑指 Offer II 063. 替换单词
* */
public class jianzhi63 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String str : dictionary){
            trie.insert(str);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            words[i] = trie.searchStart(words[i]);
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1).toString();

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

        public String searchStart(String word){
            Trie node = this;
            for(int i = 0; i < word.length(); i++){
                if(node.isEnd){
                    return word.substring(0, i);
                }
                char a = word.charAt(i);
                int index = a - 'a';
                if(node.children[index] == null){
                    return word;
                }
                node = node.children[index];
            }
            return word;
        }

    }


}
