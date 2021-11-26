package com.lyz.java;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/10/21 下午8:00
 */


public class InsertSort {
    public static void main(String[] args) {
        int [] arr = {3, 9, -1, 10, -2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
//
//        int [] arr = RandomArr.getRandomArr(80000);
//        int before = (int) System.currentTimeMillis();
//        insertSort(arr);
//        int after = (int) System.currentTimeMillis();
//        System.out.println(after - before);
    }

    public static void insertSort(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i -1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
//            if (insertIndex + 1 != i){
//
//                arr[insertIndex+1] = insertVal;
//            }

            arr[insertIndex+1] = insertVal;

//            System.out.printf("第 %d 次排序 ",i );
//            System.out.println(Arrays.toString(arr));
        }
    }
}
