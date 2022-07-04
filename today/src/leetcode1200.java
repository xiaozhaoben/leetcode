import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* 1200. 最小绝对差
* */
public class leetcode1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        if(n == 2){
            List<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            list.add(arr[1]);
            ans.add(new ArrayList<>(list));
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int[] b = new int[n];
        for (int i = 0; i < n - 1; i++){
            b[i] = arr[i + 1] - arr[i];
            min = Math.min(b[i], min);
        }
        for (int i = 0; i < n - 1; i++){
            if (b[i] == min){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                ans.add(new ArrayList<>(list));
            }
        }
        return ans;
    }


}
