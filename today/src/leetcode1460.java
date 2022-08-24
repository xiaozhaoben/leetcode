import java.util.Arrays;

/*
 * 1460. 通过翻转子数组使两个数组相等
 * */
public class leetcode1460 {

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

}
