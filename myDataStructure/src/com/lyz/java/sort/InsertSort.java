package com.lyz.java.sort;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/11/14 下午8:15
 */


public class InsertSort {
    public static void main(String[] args) {
        int[] arr = RandomArr.getRandomArr(20);
        long l = System.currentTimeMillis();
        insertSort(arr);
        long e = System.currentTimeMillis();
        System.out.println("花费时间： " + (e - l));
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        int insertIndex;
        int insertVal;
        for (int i = 1; i < arr.length; i++) {
            insertIndex = i - 1;
            insertVal = arr[i];
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }
}
