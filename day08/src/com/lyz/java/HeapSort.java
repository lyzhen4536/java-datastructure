package com.lyz.java;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/10/25 下午9:43
 */


public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        adjustHeap(arr,1,arr.length);
        adjustHeap(arr,0,arr.length);
    }

    public static void heapSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
        System.out.println("数组= " + Arrays.toString(arr));
    }

    public static void adjustHeap(int[] arr, int i, int len) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        arr[i] = temp;

        System.out.println(Arrays.toString(arr));
    }
}
