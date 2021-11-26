package com.lyz.java.sort;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/11/14 下午11:38
 */


public class QuickSort {
    public static void main(String[] args) {
        int[] arr = RandomArr.getRandomArr(20);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                l++;
            }
            if (arr[r] == pivot) {
                r--;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
