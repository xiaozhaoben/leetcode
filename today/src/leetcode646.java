import java.util.Arrays;

/*
 * 646. 最长数对链
 * */
public class leetcode646 {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a1, a2) -> {
            return a1[1] - a2[1];
        });
        int last = pairs[0][1];
        int ans = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > last) {
                last = pairs[i][1];
                ans++;
            }
        }
        return ans;
    }

}
