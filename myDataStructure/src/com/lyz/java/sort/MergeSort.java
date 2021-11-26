package com.lyz.java.sort;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/11/16 下午2:29
 */


public class MergeSort {
    public static void main(String[] args) {
        int[] arr = RandomArr.getRandomArr(20);
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));

        int[] a = RandomArr.getRandomArr(20);
        int[] sort = sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        if (left < right) {
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        t = 0;
        int tempLeft = left;

        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

    public static int[] sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            //左右归并
            merge(a, low, mid, high);
        }
        return a;
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        if (temp.length >= 0) System.arraycopy(temp, 0, a, 0 + low, temp.length);
    }

}
