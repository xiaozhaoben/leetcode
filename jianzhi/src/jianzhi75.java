import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 剑指 Offer II 075. 数组相对排序
* */
public class jianzhi75 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int i = 0;
        int[] hash = new int[1002];
        for(int arr : arr1){
            hash[arr]++;
        }
        for(int arr : arr2){
            while(hash[arr] > 0){
                arr1[i++] = arr;
                hash[arr]--;
            }
        }
        for(int n = 0; n < hash.length - 1; n++){
            while(hash[n] > 0){
                arr1[i++] = n;
                hash[n]--;
            }
        }
        return arr1;
    }

}
