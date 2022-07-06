import java.util.List;

/*
* 871. 最低加油次数
* */
public class leetcode648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(trie.getPrefix(word));
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1).toString();
    }

    class Trie{

        private Trie[] children;
        private boolean isEnd;

        public Trie(){
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word){
            Trie node = this;
            for(int i = 0; i < word.length(); i++){
                int next = word.charAt(i) - 'a';
                if (node.children[next] == null){
                    node.children[next] = new Trie();
                }
                node = node.children[next];
            }
            node.isEnd = true;
        }
        public String getPrefix(String word){
            Trie node = this;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++){
                char a = word.charAt(i);
                int next = a - 'a';
                if (node.isEnd){
                    return sb.toString();
                }
                if (node.children[next] == null){
                    return word;
                }
                sb.append(a);
                node = node.children[next];
            }
            return word;
        }

    }


}
