package com.lyz.java;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/10/21 下午9:53
 */


public class ShellSort {
    public static void main(String[] args) {
//        int [] arr = {3, 9, -1, 10, -2};
//        shellSortByChange(arr);
//        System.out.println(Arrays.toString(arr));
//
        int [] arr = RandomArr.getRandomArr(80000);
//        int before = (int) System.currentTimeMillis();
//        shellSortByChange(arr);
//        int after = (int) System.currentTimeMillis();
//        System.out.println(after - before);


        int before = (int) System.currentTimeMillis();
        shellSortByMove(arr);
        int after = (int) System.currentTimeMillis();
        System.out.println(after - before);



    }

    public static void shellSortByChange(int [] arr){
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i -gap; j >= 0 ; j -= gap) {
                    if (arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    public static void shellSortByMove(int [] arr){
        int j = 0;
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {

                j = i;
                temp = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && temp < arr[j - gap]){
                        arr[j] = arr[j -gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
