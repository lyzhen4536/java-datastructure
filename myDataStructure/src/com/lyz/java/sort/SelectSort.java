package com.lyz.java.sort;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/11/14 下午7:57
 */


public class SelectSort {
    public static void main(String[] args) {
        int[] arr = RandomArr.getRandomArr(20);
        long l = System.currentTimeMillis();
        selectSort(arr);
        long e = System.currentTimeMillis();
        System.out.println("花费时间： " + (e - l));
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        //选择排序时间复杂度是 O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明假定的最小值，并不是最小
                    min = arr[j]; // 重置 min
                    minIndex = j; // 重置 minIndex
                }
            }
            // 将最小值，放在 arr[0], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
