import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 241. 为运算表达式设计优先级
 * */
public class leetcode3477 {


    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int[] arr = new int[n];
        int count = 0;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if (baskets[j] >= fruits[i] && arr[j] != 1) {
                    arr[j] = 1;
                    count++;
                    break;
                }
            }
        }
        return n - count;
    }

    public static void main(String[] args) {
        System.out.println(numOfUnplacedFruits(new int[]{3,6,1}, new int[]{6,4,7}));
    }

}
