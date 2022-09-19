import java.util.Arrays;

/*
 * 1624. 两个相同字符之间的最长子字符串
 * */
public class leetcode1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] a = new int[26];
        int ans = -1;
        Arrays.fill(a, -1);
        for (int i = 0; i < s.length(); i++) {
            if (a[s.charAt(i) - 'a'] == -1) {
                a[s.charAt(i) - 'a'] = i;
            } else {
                ans = Math.max(i - a[s.charAt(i) - 'a'] - 1, ans);
            }
        }
        return ans;
    }

}
