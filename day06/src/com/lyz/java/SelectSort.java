package com.lyz.java;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/10/21 下午7:31
 */


public class SelectSort {
    public static void main(String[] args) {
        int [] arr1 = {3, 9, -1, 10, -2};
        selectSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int [] arr2 = RandomArr.getRandomArr(80000);
        int before = (int) System.currentTimeMillis();
        selectSort(arr2);
        int after = (int) System.currentTimeMillis();
        System.out.println(after - before);
    }

    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length ; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

//            System.out.printf("第 %d 次排序 ",i +1);
//            System.out.println(Arrays.toString(arr));
        }
    }
}
