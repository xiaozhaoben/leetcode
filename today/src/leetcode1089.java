import java.util.Arrays;

/*
* 1089. 复写零
* */
public class leetcode1089 {

    public void duplicateZeros(int[] arr) {
        int index = 0, cur = 0, length = arr.length;
        int[] copy = Arrays.copyOf(arr, length);
        while(cur < length){
            if(index < length && copy[index] == 0){
                arr[cur++] = 0;
            }
            if(cur < length && index < length){
                arr[cur++] = copy[index++];
            }
        }
    }

//    public void duplicateZeros(int[] arr) {
//        int n = arr.length, i = 0, j = 0;
//        while (j < n) {
//            if (arr[i] == 0) j++;
//            i++; j++;
//        }
//        i--; j--;
//        while (i >= 0) {
//            if (j < n) arr[j] = arr[i];
//            if (arr[i] == 0) {
//                arr[--j] = 0;
//            }
//            i--; j--;
//        }
//    }

}
