import java.util.ArrayList;
import java.util.List;

/*
 * 1417. 重新格式化字符串
 * */
public class leetcode1417 {

    public String reformat(String s) {
        List<Character> num = new ArrayList<>();
        List<Character> word = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num.add(c);
            } else {
                word.add(c);
            }
        }
        if (Math.abs(num.size() - word.size()) > 1) {
            return "";
        }
        if (num.size() > word.size()) {
            return concat(num, word);
        } else {
            return concat(word, num);
        }
    }

    public String concat(List<Character> a, List<Character> b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.size() || i < b.size(); i++) {
            if (i < a.size()) sb.append(a.get(i));
            if (i < b.size()) sb.append(b.get(i));
        }
        return sb.toString();
    }
}
