public class leetcode1422 {

    public int maxScore(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                right++;
            }
        }
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                left++;
            }
            if (s.charAt(i) == '1') {
                right--;
            }
            max = Math.max(left + right, max);
        }
        return max;
    }

}
