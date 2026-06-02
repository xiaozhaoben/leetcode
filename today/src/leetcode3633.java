
import java.util.Arrays;


public class leetcode3633 {


    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landFirst = solve(landStartTime, landDuration, waterStartTime, waterDuration);
        int waterFirst = solve(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(landFirst, waterFirst);
    }

    public static int solve(int[] firstStart, int[] firstDuration, int[] secondStart, int[] secondDuration) {
        int n = secondStart.length;
        int[][] rides = new int[n][2];
        for (int i = 0; i < n; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDuration[i];
        }

        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

        int[] starts = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = rides[i][0];
        }

        int[] prefixMinDuration = new int[n];
        prefixMinDuration[0] = rides[0][1];

        for (int i = 1; i < n; i++) {
            prefixMinDuration[i] = Math.min(prefixMinDuration[i - 1], rides[i][1]);
        }

        int[] suffixMinFinish = new int[n + 1];
        suffixMinFinish[n] = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            int start = rides[i][0];
            int duration = rides[i][1];
            suffixMinFinish[i] = Math.min(suffixMinFinish[i + 1], start + duration);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {
            int start = firstStart[i];
            int duration = firstDuration[i];

            int time = start + duration;
            int index = upperBound(starts, time);

            if (index > 0) {
                ans = Math.min(ans, prefixMinDuration[index - 1] + time);
            }

            if (index < n) {
                ans = Math.min(ans, suffixMinFinish[index]);
            }

        }

        return ans;


    }

    public static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};

        System.out.println(earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }


}
