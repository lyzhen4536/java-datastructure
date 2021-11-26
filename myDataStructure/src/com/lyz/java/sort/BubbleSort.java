package com.lyz.java.sort;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/11/14 下午7:28
 */


public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = RandomArr.getRandomArr(20);
        long l = System.currentTimeMillis();
        bubbleSort(arr);
        long e = System.currentTimeMillis();
        System.out.println("花费时间： " + (e - l));
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
