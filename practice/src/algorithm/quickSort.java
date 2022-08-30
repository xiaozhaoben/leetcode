package algorithm;

import java.util.Arrays;

public class quickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int target = arr[left], i = left, j = right;
        while (i < j) {
            while (arr[j] >= target && i < j) {
                j--;
            }
            while (arr[i] <= target && i < j) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, left);
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[999999];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * arr.length);
        }
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        quickSort(arr, 0, arr.length - 1);
        Arrays.sort(arrCopy);
        System.out.println(Arrays.equals(arr, arrCopy));
    }

}
