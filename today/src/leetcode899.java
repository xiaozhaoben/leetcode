import java.util.Arrays;

/*
 * 899. 有序队列
 * */
public class leetcode899 {

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            int n = s.length();
            StringBuilder sb = new StringBuilder(s);
            String ans = sb.toString();
            for (int i = 1; i < n; i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if (ans.compareTo(sb.toString()) > 0) {
                    ans = sb.toString();
                }
            }
            return ans;
        } else {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            return String.valueOf(array);
        }
    }

}
