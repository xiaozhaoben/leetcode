import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/*
* 745. 前缀和后缀搜索
* */
public class leetcode745 {

        class WordFilter {
            Map<String, Integer> dictionary;

            public WordFilter(String[] words) {
                dictionary = new HashMap<String, Integer>();
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    int m = word.length();
                    for (int prefixLength = 1; prefixLength <= m; prefixLength++) {
                        for (int suffixLength = 1; suffixLength <= m; suffixLength++) {
                            dictionary.put(word.substring(0, prefixLength) + "#" + word.substring(m - suffixLength), i);
                        }
                    }
                }
            }

            public int f(String pref, String suff) {
                return dictionary.getOrDefault(pref + "#" + suff, -1);
            }
        }
}
