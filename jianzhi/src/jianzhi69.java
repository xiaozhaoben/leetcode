/*
* 剑指 Offer II 069. 山峰数组的顶部
* */
public class jianzhi69 {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1, mid = 0;
        while(left <= right){
            mid = left + ((right - left) >> 1);
            if(mid <= arr.length - 1 && arr[mid] < arr[mid + 1]){
                left = mid + 1;
            }else if(mid <= arr.length - 1 && arr[mid] > arr[mid + 1]){
                right = mid - 1;
            }
        }
        return left;
    }


}
