package com.lyz.java.sort;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/11/14 下午9:43
 */


public class ShellSort {
    public static void main(String[] args) {
        int[] arr = RandomArr.getRandomArr(20);
        int[] arr1 = {3, 9, -1, 10, -2};
        long l = System.currentTimeMillis();
        shellSortByMove(arr);
        shellSortByMove(arr1);
        long e = System.currentTimeMillis();
        System.out.println("花费时间： " + (e - l));
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));

    }

    public static void shellSortByChange(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    public static void shellSortByMove(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
        // 从第 gap 个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];

                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                    //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出 while 后，就给 temp 找到插入的位置
                    arr[j] = temp;
                }
            }
        }
    }
}
