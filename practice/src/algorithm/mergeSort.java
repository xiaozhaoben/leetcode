package algorithm;

import java.util.Arrays;

/*
 * 归并排序
 * */
public class mergeSort {

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }

    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int leftTemp = left, rightTemp = mid + 1;
        int t = 0;
        while (leftTemp <= mid && rightTemp <= right) {
            if (arr[leftTemp] <= arr[rightTemp]) {
                temp[t++] = arr[leftTemp++];
            } else {
                temp[t++] = arr[rightTemp++];
            }
        }
        while (leftTemp <= mid) {
            temp[t++] = arr[leftTemp++];
        }
        while (rightTemp <= right) {
            temp[t++] = arr[rightTemp++];
        }
        leftTemp = left;
        t = 0;
        while (leftTemp <= right) {
            arr[leftTemp++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, -1, 3, 4, 56, 67, 132, 145, 2, 1};
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

}
